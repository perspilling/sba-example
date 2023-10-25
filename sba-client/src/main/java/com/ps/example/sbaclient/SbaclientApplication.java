package com.ps.example.sbaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(JolokiaConfiguration.class)
public class SbaclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbaclientApplication.class, args);
	}

}
