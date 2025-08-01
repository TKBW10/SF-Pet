package com.pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SfPetApplication {

    public static void main(String[] args) {
        SpringApplication.run(SfPetApplication.class, args);
    }

}
