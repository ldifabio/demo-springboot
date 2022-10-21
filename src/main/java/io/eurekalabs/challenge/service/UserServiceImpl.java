package io.eurekalabs.challenge.service;

import io.eurekalabs.challenge.controller.request.UserRequest;
import io.eurekalabs.challenge.controller.response.UserResponse;
import io.eurekalabs.challenge.domain.User;
import io.eurekalabs.challenge.exception.ApiKeyNotFoundException;
import io.eurekalabs.challenge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserResponse register(UserRequest userRequest) {
        UserResponse userResponse;
        User user = repository.save(new User(userRequest.getUsername(), userRequest.getPassword(),
                userRequest.getName(), userRequest.getLastName(), userRequest.getEmail()));
        userResponse = new UserResponse(user.getApiKey(), user.getCreationDate(), user.isEnabled());
        return userResponse;
    }

    @Override
    public void validApiKey(String apiKey) {
        repository.queryByApiKey(apiKey).filter(User::isEnabled)
                .orElseThrow(() -> new ApiKeyNotFoundException(apiKey));
    }
}
