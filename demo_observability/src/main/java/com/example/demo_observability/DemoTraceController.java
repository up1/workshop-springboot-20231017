package com.example.demo_observability;

import io.micrometer.observation.annotation.Observed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoTraceController {

    private final DemoService demoService;

    public DemoTraceController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("hi")
    @Observed(name = "do.sth", contextualName = "say-hi")
    public String sayHi() {
        return demoService.doSth("123");
    }

}
