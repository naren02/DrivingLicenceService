package com.example.dl.service;

import com.example.dl.model.LicenseApplication;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class LicenseEligibilityService {

    private final KieContainer kieContainer;

    public LicenseEligibilityService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public LicenseApplication evaluate(LicenseApplication application) {
        KieSession kieSession = kieContainer.newKieSession();
        try {
            application.setEligible(false);
            kieSession.insert(application);
            kieSession.fireAllRules();
            return application;
        } finally {
            kieSession.dispose();
        }
    }
}
