package io.eurekalabs.challenge.repository;

import io.eurekalabs.challenge.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> queryByApiKey(String apiKey);

}

