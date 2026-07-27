package com.anuj.creatorstore.repositories;

import com.anuj.creatorstore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
