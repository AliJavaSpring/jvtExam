package com.alihan.javarush.jvt.repo;

import com.alihan.javarush.jvt.entity.User;
import com.alihan.javarush.jvt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
