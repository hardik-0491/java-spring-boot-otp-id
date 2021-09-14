package com.hardik.otp.id.controllers;

import com.hardik.otp.id.services.IdGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UniqueIdController {

    @Autowired
    IdGeneratorService idGeneratorService;

    @GetMapping(value = "/get")
    public String getUniqueId() {
        return idGeneratorService.generateId();
    }

}
