package com.security.applicationsecure.repositories;

import com.security.applicationsecure.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {
    User findByusername(String username);

    User findByusernameAndPassword(String username, String password);
}
