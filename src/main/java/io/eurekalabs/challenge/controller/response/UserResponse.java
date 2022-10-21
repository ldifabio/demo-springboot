package io.eurekalabs.challenge.controller.response;

import lombok.Data;

import java.util.Date;

@Data
public class UserResponse {

    private String apiKey;
    private Date creationDate;
    private boolean enabled;

    public UserResponse(String apiKey, Date creationDate, boolean enabled) {
        this.apiKey = apiKey;
        this.creationDate = creationDate;
        this.enabled = enabled;
    }
}
