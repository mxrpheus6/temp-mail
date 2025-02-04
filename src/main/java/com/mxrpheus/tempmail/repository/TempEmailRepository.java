package com.mxrpheus.tempmail.repository;

import com.mxrpheus.tempmail.model.TempEmail;

import java.util.Optional;

public interface TempEmailRepository {
    TempEmail save(TempEmail tempEmail);
    Optional<TempEmail> findById(Long id);
    void delete(Long id);
    void cleanupExpired();
}
