package com.uptempo.ams.model.request;

import lombok.Data;

@Data
public class CreateSessionRequest {

    private String password;
    private String email;

}
