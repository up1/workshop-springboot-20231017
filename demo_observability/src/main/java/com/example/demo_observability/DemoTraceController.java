package com.example.demo_observability;

import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoTraceController {
    private static final Logger log = LoggerFactory.getLogger(DemoTraceController.class);

    private final DemoService demoService;

    public DemoTraceController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("hi")
    @Observed(name = "do.sth", contextualName = "say-hi")
    public String sayHi() {
        log.info("Got a request of sayHi");
        return demoService.doSth("123");
    }

}
