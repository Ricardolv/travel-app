package com.richard.application.healthcheck;

import com.richard.infrastructure.presistences.CustumerEntity;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import static java.util.Objects.isNull;

@Readiness
public class ReadinessCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {

        if(isNull(CustumerEntity.listAll()))  {
            return HealthCheckResponse.down("I`m not ready");
        } else {
            return HealthCheckResponse.up("I`m ready");
        }
    }
}
