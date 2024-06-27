package com.intellipaat.monitor;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
public class ActuatorConfig {
    private Counter requestCounter;

    @Autowired
    public ActuatorConfig(MeterRegistry registry) {
        this.requestCounter = Counter.builder("api.xyz.requests")
                                     .description("Total number of requests to /api/xyz")
                                     .register(registry);
    }

    @RestController
    @RequestMapping("/api")
    public class ApiController {
        @GetMapping("/xyz")
        public String handleRequest() {
            requestCounter.increment();
            return "Handled /api/xyz request";
        }
    }
}
