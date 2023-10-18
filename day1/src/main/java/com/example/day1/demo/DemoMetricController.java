package com.example.day1.demo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoMetricController {

    @Autowired
    private MeterRegistry meterRegistry;

    @GetMapping("/count/{message}")
    public ResponseEntity<String> count(@PathVariable String message) {
        if("success".equals(message)) {
            generateMetric("success");
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } else if("notfound".equals(message)) {
            generateMetric("notfound");
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
        generateMetric("error");
        return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void generateMetric(String status) {
        Counter counter = Counter
                .builder("hello-springboot")
                .description("Demo case")
                .tag("result", status)
                .register(meterRegistry);
        counter.increment();
    }

}