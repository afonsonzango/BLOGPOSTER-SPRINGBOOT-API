package com.bloger.afonsonzango.api.features.user.infrastructures.repositories;

import com.bloger.afonsonzango.api.features.user.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface user_repository extends JpaRepository<User, Long> {
    List<User> findByNameContaining(String substring);
    List<User> findByEmail(String substring);
}