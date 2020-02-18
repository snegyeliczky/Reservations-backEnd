package com.codecool.reservationsbackend.repositories;

import com.codecool.reservationsbackend.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);
}
