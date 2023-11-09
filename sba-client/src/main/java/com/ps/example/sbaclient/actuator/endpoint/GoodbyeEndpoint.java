package com.ps.example.sbaclient.actuator.endpoint;

import com.ps.example.sbaclient.service.hello.Greeting;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

@Component
@Endpoint(id = "goodbye")
public class GoodbyeEndpoint {

    private static final String goodbye_template = "Goodbye, %s!";
    private final AtomicLong counter = new AtomicLong();

    @ReadOperation
    @GetMapping("/goodbye")
    public Greeting sayGoodbye(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(goodbye_template, name));
    }
}
