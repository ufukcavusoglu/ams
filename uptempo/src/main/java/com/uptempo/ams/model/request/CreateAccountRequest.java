package com.uptempo.ams.model.request;

import lombok.Data;

@Data
public class CreateAccountRequest {

    private String email;
    private String password;

}
