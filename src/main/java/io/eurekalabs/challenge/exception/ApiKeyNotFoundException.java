package io.eurekalabs.challenge.exception;

public class ApiKeyNotFoundException extends RuntimeException {

    public ApiKeyNotFoundException(String apikey) {
        super("ApiKey not found " + apikey);
    }
}
