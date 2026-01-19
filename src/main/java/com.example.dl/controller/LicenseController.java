package com.example.dl.controller;

import com.example.dl.model.LicenseApplication;
import com.example.dl.service.LicenseEligibilityService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/license")
public class LicenseController {

    private final LicenseEligibilityService service;

    public LicenseController(LicenseEligibilityService service) {
        this.service = service;
    }

    @PostMapping("/evaluate")
    public LicenseApplication evaluate(@RequestBody LicenseApplication application) {
        return service.evaluate(application);
    }
}
