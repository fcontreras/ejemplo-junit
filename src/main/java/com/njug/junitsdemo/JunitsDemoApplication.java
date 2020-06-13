package com.njug.junitsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JunitsDemoApplication implements CommandLineRunner {

    @Autowired
    ServicioDeCalculadora servicioDeCalculadora;

    public static void main(String[] args) {
        SpringApplication.run(JunitsDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {}
}
