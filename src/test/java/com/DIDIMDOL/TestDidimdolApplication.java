package com.DIDIMDOL;

import org.springframework.boot.SpringApplication;

public class TestDidimdolApplication {

	public static void main(String[] args) {
		SpringApplication.from(DidimdolApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
