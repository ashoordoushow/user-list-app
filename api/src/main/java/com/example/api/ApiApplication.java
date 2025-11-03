package com.example.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.api.models.Role;
import com.example.api.models.User;
import com.example.api.repositories.UserRepository;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
    CommandLineRunner seedDatabase(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {  
                userRepository.save(new User("John", "Doe", "john@example.com", Role.ADMIN));
                userRepository.save(new User("Jane", "Smith", "jane@example.com", Role.MANAGER));
                userRepository.save(new User("Alex", "Brown", "alex@example.com", Role.STAFF));
                userRepository.save(new User("Lisa", "White", "lisa@example.com", Role.STAFF));
                userRepository.save(new User("Michael", "Green", "michael@example.com", Role.MANAGER));
                userRepository.save(new User("Emily", "Davis", "emily@example.com", Role.ADMIN));
                userRepository.save(new User("Robert", "Johnson", "robert@example.com", Role.STAFF));
                userRepository.save(new User("Sarah", "Taylor", "sarah@example.com", Role.MANAGER));
                userRepository.save(new User("David", "Miller", "david@example.com", Role.STAFF));
                userRepository.save(new User("Olivia", "Anderson", "olivia@example.com", Role.STAFF));
            }
        };
    }
}