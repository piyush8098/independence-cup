package com.cup.independence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class IndependenceCupApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(IndependenceCupApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(IndependenceCupApplication.class);
    }
}
