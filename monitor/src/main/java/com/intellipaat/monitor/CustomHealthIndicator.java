package com.intellipaat.monitor;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        // Custom logic to determine health status
        boolean healthy = true; // replace with actual health check
        if (healthy) {
            return Health.up().withDetail("status", "All services are running").build();
        }
        return Health.down().withDetail("status", "Some services are not available").build();
    }
}
