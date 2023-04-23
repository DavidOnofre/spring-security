package com.kodigo;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBankApplication.class, args);
	}

	// Ingresar a la consola de h2
	@Bean
	org.h2.tools.Server h2Server() {
		Server server = new Server();
		try {
			server.runTool("-tcp");
			server.runTool("-tcpAllowOthers");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return server;
	}

}
