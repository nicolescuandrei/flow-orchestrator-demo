package com.andreinicolescu.demo.floworchestratordemo;

import com.andreinicolescu.webflow.floworchestrator.annotation.EnableFlowOrchestrator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableFlowOrchestrator
@SpringBootApplication
public class FlowOrchestratorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowOrchestratorDemoApplication.class, args);
    }

}
