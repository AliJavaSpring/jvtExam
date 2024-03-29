package com.alihan.javarush.jvt.repo;

import com.alihan.javarush.jvt.entity.Role;
import com.alihan.javarush.jvt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
