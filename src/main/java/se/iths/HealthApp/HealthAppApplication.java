package se.iths.HealthApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.iths.HealthApp.entity.RoleEntity;
import se.iths.HealthApp.repository.RoleRepository;

@SpringBootApplication
public class HealthAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthAppApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner setUpRoles(RoleRepository roleRepository) {
//        return (args)-> {
//            roleRepository.save(new RoleEntity("ROLE_ADMIN"));
//            roleRepository.save(new RoleEntity("ROLE_USER"));
//        };
}


