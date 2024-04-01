package org.example;

import org.example.entities.CategoryEntity;
import org.example.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.example.storage.StorageProperties;
import org.example.storage.StorageService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Bean
    CommandLineRunner runner(CategoryRepository categoryRepository, StorageService storageService) {
        return args -> {
            storageService.init();
        };
    }
}