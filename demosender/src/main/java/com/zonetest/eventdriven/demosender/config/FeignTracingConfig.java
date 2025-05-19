package com.zonetest.eventdriven.demosender.config;

import feign.RequestInterceptor;
import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//feign call interceptor to set zipkin headers - no need if eureka used
@Configuration
public class FeignTracingConfig {

    @Bean
    public RequestInterceptor traceContextInterceptor(Tracer tracer) {
        return requestTemplate -> {
            Span currentSpan = tracer.currentSpan();
            if (currentSpan != null) {
                requestTemplate.header("X-B3-TraceId", currentSpan.context().traceId());
                requestTemplate.header("X-B3-SpanId", currentSpan.context().spanId());
                requestTemplate.header("X-B3-Sampled", currentSpan.context().sampled() ? "1" : "0");

                // Optional: Add parent span if needed
                if (currentSpan.context().parentId() != null) {
                    requestTemplate.header("X-B3-ParentSpanId", currentSpan.context().parentId());
                }
            }
        };
    }
}
