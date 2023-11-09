package com.ps.example.sbaclient.actuator.endpoint;

import com.ps.example.sbaclient.service.hello.Greeting;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

@Component
@Endpoint(id="helloEndpoint")
public class HelloEndpoint {

    private static final String hello_template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @ReadOperation
    @GetMapping("/hello")
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(hello_template, name));
    }
}
