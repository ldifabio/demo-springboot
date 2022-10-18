package io.eurekalabs.challenge.controller;

import io.eurekalabs.challenge.controller.request.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@Slf4j
public class CrearUsuarioController {


    @PostMapping("/usuarios")
    public ResponseEntity guardar(@Valid @RequestBody UserRequest request) {
        log.debug("Creando usuario {} con los datos {}", request.getUsername(), request);

        try {
            return ResponseEntity.ok(request);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw e;
        }
    }
}
