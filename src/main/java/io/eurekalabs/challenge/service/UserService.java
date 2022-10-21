package io.eurekalabs.challenge.service;

import io.eurekalabs.challenge.controller.request.UserRequest;
import io.eurekalabs.challenge.controller.response.UserResponse;


public interface UserService {

    UserResponse register(UserRequest userRequest);

    void validApiKey(String apiKey);
}
