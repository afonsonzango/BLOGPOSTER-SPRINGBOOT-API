package com.bloger.afonsonzango.api.features.user.application.delete_user;

import com.bloger.afonsonzango.api.features.user.infrastructures.repositories.user_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService {
    private final user_repository userRepository;

    @Autowired
    public DeleteUserService(user_repository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
