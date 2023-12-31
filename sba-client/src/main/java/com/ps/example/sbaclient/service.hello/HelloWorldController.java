package com.ps.example.sbaclient.service.hello;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@Endpoint(id = "hello") // will expose this as a JMX mbean
public class HelloWorldController {

    private static final String hello_template = "Hello, %s!";
    private static final String goodbye_template = "Goodbye, %s!";
    private final AtomicLong counter = new AtomicLong();

    @ReadOperation
    @GetMapping("/hello")
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(hello_template, name));
    }

    @GetMapping("/goodbye")
    public Greeting sayGoodbye(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(goodbye_template, name));
    }
}
