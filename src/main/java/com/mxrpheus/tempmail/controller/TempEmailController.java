package com.mxrpheus.tempmail.controller;

import com.mxrpheus.tempmail.model.TempEmail;
import com.mxrpheus.tempmail.service.TempEmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/email")
public class TempEmailController {
    private final TempEmailService tempEmailService;

    public TempEmailController(TempEmailService tempEmailService) {
        this.tempEmailService = tempEmailService;
    }

    @PostMapping
    public ResponseEntity<TempEmail> generateTempEmail() {
        return ResponseEntity.ok(tempEmailService.generateTempEmail());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TempEmail> getTempEmail(@PathVariable Long id) {
        return ResponseEntity.ok(tempEmailService.getTempEmail(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTempMail(@PathVariable Long id) {
        tempEmailService.deleteTempEmail(id);
        return ResponseEntity.noContent().build();
    }
}
