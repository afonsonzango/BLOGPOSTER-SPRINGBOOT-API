package com.bloger.afonsonzango.api.features.user.application.update_user;

import com.bloger.afonsonzango.api.features.user.adapters.dtos.request_dto.UpdateUserDTO;
import com.bloger.afonsonzango.api.features.user.adapters.dtos.response_dto.ResponseUserDTO;
import com.bloger.afonsonzango.api.features.user.adapters.dtos.response_mappers.UserResponseMapper;
import com.bloger.afonsonzango.api.features.user.infrastructures.repositories.user_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserService {
    private final user_repository userRepository;

    @Autowired
    public UpdateUserService (user_repository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<ResponseUserDTO> updateUser(Long id, UpdateUserDTO userUpdateDTO) {
        return userRepository.findById(id).map(user -> {
            user.setName(userUpdateDTO.getName() == null ? user.getName() : userUpdateDTO.getName());
            user.setEmail(userUpdateDTO.getEmail() == null ? user.getEmail() : userUpdateDTO.getEmail());
            user.setEmail(userUpdateDTO.getPassword() == null ? user.getPassword() : userUpdateDTO.getPassword());

            userRepository.save(user);
            return UserResponseMapper.user_response_mapper(user);
        });
    }
}