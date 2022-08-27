package com.tarantula.InDepth.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "analyze")
public class AnalyzeEndpoint {
    private final Map<String,StatsClass> statsMap = new ConcurrentHashMap<>();

    public AnalyzeEndpoint() {
        statsMap.put("Employee", new StatsClass(true));
        statsMap.put("User", new StatsClass(false));
        statsMap.put("Auth", new StatsClass(false));
    }

    @ReadOperation
    public Map<String, StatsClass> stats() {
        return statsMap;
    }

    @ReadOperation
    public StatsClass stat(@Selector String statName) {
        return statsMap.get(statName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class StatsClass {
        private boolean isEnabled;
    }
}
