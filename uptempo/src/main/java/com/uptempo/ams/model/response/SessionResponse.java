package com.uptempo.ams.model.response;

import lombok.Data;

import java.util.UUID;

@Data
public class SessionResponse {

    private UUID id;
    private String ipAddress;
    private AccountResponse account;

}
