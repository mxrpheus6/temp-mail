package com.mxrpheus.tempmail.repository.impl;

import com.mxrpheus.tempmail.model.TempEmail;
import com.mxrpheus.tempmail.repository.TempEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TempTempEmailRepositoryImpl implements TempEmailRepository {
    private final Map<Long, TempEmail> emails = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public TempEmail save(TempEmail tempEmail) {
        tempEmail.setId(idGenerator.getAndIncrement());
        return emails.put(tempEmail.getId(), tempEmail);
    }

    @Override
    public Optional<TempEmail> findById(Long id) {
        return Optional.ofNullable(emails.get(id));
    }

    @Override
    public void delete(Long id) {
        emails.remove(id);
    }

    @Override
    public void cleanupExpired() {
        emails.entrySet().removeIf(entry -> entry.getValue().isExpired());
    }
}
