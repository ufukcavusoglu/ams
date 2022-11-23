package com.uptempo.ams.model.response;

import lombok.Data;

@Data
public class CreateSessionResponse {

    private SessionResponse session;
    private String token;
}
