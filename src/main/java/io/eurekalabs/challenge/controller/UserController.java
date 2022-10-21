package io.eurekalabs.challenge.controller;

import io.eurekalabs.challenge.controller.request.UserRequest;
import io.eurekalabs.challenge.controller.response.UserResponse;
import io.eurekalabs.challenge.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> guardar(@Valid @RequestBody UserRequest request) {
        log.debug("Creando usuario con los datos {}", request);
        try {
            return ResponseEntity.ok(service.register(request));
        } catch (Exception e) {
            log.info(e.getMessage());
            throw e;
        }
    }
}
