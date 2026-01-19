package com.example.dl.config;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

   /* @Bean
    public KieContainer kieContainer() {
        KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
        KieBase kieBase = kieContainer.getKieBase("rulesBase");
        System.out.println("KieBase has KiePackages: " + kieBase.getKiePackages().size());


        return kieContainer;
    }*/
    private static final String drl_file_path = "rules/driving-license-rules.drl";

    private static final KieServices kieServices = KieServices.Factory.get();

    @Bean
    public KieContainer kieContainer() {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(drl_file_path));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
        return kieContainer;
    }
}
