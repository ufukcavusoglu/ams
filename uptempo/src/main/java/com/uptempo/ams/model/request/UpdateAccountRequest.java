package com.uptempo.ams.model.request;

import lombok.Data;

@Data
public class UpdateAccountRequest {

    private String email;
    private Boolean markedForDeletion;
}
