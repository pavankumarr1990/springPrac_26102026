package com.prac26102026.prac1.repo;


import com.prac26102026.prac1.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

    Optional<ApplicationUser> findByUserName(String userName);

    Optional<ApplicationUser> findByUsername(String username);
    Optional<ApplicationUser> findByUserNameIgnoreCase(String userName);
}
