package com.ps.example.sbaserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@EnableAdminServer
@SpringBootApplication
@Import(JolokiaConfiguration.class)
public class SbaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbaServerApplication.class, args);
	}

}
