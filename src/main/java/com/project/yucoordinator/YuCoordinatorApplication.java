package com.project.yucoordinator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class YuCoordinatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuCoordinatorApplication.class, args);
    }

}
