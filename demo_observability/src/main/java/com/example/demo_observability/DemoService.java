package com.example.demo_observability;

import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DemoService {
    private static final Logger log = LoggerFactory.getLogger(DemoService.class);
    private final Random random = new Random();

    @Observed(name = "do.sth", contextualName = "try-do-something")
    String doSth(String userId) {
        log.info("Do something <{}>", userId);
        try {
            Thread.sleep(random.nextLong(200L)); // simulates latency
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "TODO Next";
    }
}
