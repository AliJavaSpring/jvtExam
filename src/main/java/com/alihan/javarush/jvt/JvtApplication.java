package com.alihan.javarush.jvt;

import com.alihan.javarush.jvt.entity.Role;
import com.alihan.javarush.jvt.entity.User;
import com.alihan.javarush.jvt.repo.UserRepo;
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
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Алихан", "alihan", "123",  new ArrayList<>()));
            userService.saveUser(new User(null, "Андрей", "andrey", "1234",  new ArrayList<>()));
            userService.saveUser(new User(null, "Александр", "alexander", "12345",  new ArrayList<>()));

            // В миграцию добавить трех пользователей (ROLE_SUPER_ADMIN, ROLE_USER) //
            userService.addRoleToUser("alihan", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("andrey", "ROLE_USER");
            userService.addRoleToUser("alexander", "ROLE_USER");

            userService.deleteUser("alihan" , "ROLE_SUPER_ADMIN", null);
        };
    }

}
