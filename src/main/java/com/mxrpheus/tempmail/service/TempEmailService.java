package com.mxrpheus.tempmail.service;

import com.mxrpheus.tempmail.model.TempEmail;

public interface TempEmailService {
    TempEmail generateTempEmail();
    TempEmail getTempEmail(Long id);
    void deleteTempEmail(Long id);
    void cleanUpExpired();
}
