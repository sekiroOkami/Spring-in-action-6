package com.springinaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
public class TacocloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacocloudApplication.class, args);
	}

	public static void checkPath(Path path) {
		System.out.println("Files.exists(path) = " + Files.exists(path));
	}

}
