package com.mxrpheus.tempmail.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TempEmail {
    private Long id;
    private String email;
    private LocalDateTime expirationTime;

    public TempEmail(String email, int lifetimeMinutes) {
        this.email = email;
        this.expirationTime = LocalDateTime.now().plusMinutes(lifetimeMinutes);
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expirationTime);
    }
}
