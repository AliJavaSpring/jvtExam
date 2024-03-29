package com.alihan.javarush.jvt;

import com.alihan.javarush.jvt.entity.Role;
import com.alihan.javarush.jvt.entity.User;
import com.alihan.javarush.jvt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class JvtApplication {

    public static void main(String[] args) {
        SpringApplication.run(JvtApplication.class, args);
    }
    CommandLineRunner run(UserService userService) {
        return arg -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Арген", "argen", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Бекзат", "bekzat", "5678", new ArrayList<>()));
            userService.saveUser(new User(null, "Ахмед", "ahmed", "234", new ArrayList<>()));
            userService.saveUser(new User(null, "Аскар", "askar", "567", new ArrayList<>()));

            userService.addRoleToUser("argen", "ROLE_USER");
            userService.addRoleToUser("bekzat", "ROLE_USER");
            userService.addRoleToUser("ahmed", "ROLE_MANAGER");
            userService.addRoleToUser("askar", "ROLE_ADMIN");
            userService.addRoleToUser("argen", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("bekzat", "ROLE_ADMIN");
            userService.addRoleToUser("askar", "ROLE_USER");
        };
    }

}
