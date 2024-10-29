package com.bloger.afonsonzango.api.features.user.application.get_user;

import com.bloger.afonsonzango.api.features.user.adapters.dtos.response_dto.ResponseUserDTO;
import com.bloger.afonsonzango.api.features.user.adapters.dtos.response_mappers.UserResponseMapper;
import com.bloger.afonsonzango.api.features.user.infrastructures.repositories.user_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetUserService {
    private final user_repository userRepository;

    @Autowired
    public GetUserService(user_repository userRepository) {
        this.userRepository = userRepository;
    }

    public List<ResponseUserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseMapper::user_response_mapper)
                .collect(Collectors.toList());
    }

    public Optional<ResponseUserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(UserResponseMapper::user_response_mapper);
    }

    public List<ResponseUserDTO> getUserByName(String name) {
        return userRepository.findByNameContaining(name)
                .stream()
                .map(UserResponseMapper::user_response_mapper)
                .collect(Collectors.toList());
    }
}


















