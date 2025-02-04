package com.mxrpheus.tempmail.service.impl;

import com.mxrpheus.tempmail.model.TempEmail;
import com.mxrpheus.tempmail.repository.TempEmailRepository;
import com.mxrpheus.tempmail.service.TempEmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class TempEmailServiceImpl implements TempEmailService {
    private final TempEmailRepository tempEmailRepository;
    private final String domain = "gmail.com";
    private final Random random = new Random();

    public TempEmailServiceImpl(TempEmailRepository tempEmailRepository) {
        this.tempEmailRepository = tempEmailRepository;
    }

    @Override
    public TempEmail generateTempEmail() {
        int localPart = random.nextInt(10000);
        String emailAddress = localPart + "@" + domain;
        TempEmail tempEmail = new TempEmail(emailAddress, 1);
        tempEmailRepository.save(tempEmail);
        return tempEmail;
    }

    // TODO: implement null check
    @Override
    public TempEmail getTempEmail(Long id) {
        Optional<TempEmail> optionalEmail = tempEmailRepository.findById(id);
        return optionalEmail.orElse(null);
    }

    @Override
    public void deleteTempEmail(Long id) {
        tempEmailRepository.delete(id);
    }

    @Override
    @Scheduled(fixedDelay = 60000)
    public void cleanUpExpired() {
        tempEmailRepository.cleanupExpired();
    }
}
