package com.example.dl.service;

import com.example.dl.model.LicenseApplication;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
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
            System.out.println("Inserted fact: " + application.getAge());
            System.out.println("Inserted app id: " + application.getApplicantId());
            System.out.println("Inserted fact: " + application.getDateOfBirth());
            int firedRules = kieSession.fireAllRules();
            System.out.println("Fired rules: " + firedRules);
            return application;
        } finally {
            kieSession.dispose();
        }
    }
}
