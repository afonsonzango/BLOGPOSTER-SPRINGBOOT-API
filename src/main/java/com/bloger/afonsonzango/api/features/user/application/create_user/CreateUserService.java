package com.bloger.afonsonzango.api.features.user.application.create_user;

import com.bloger.afonsonzango.api.features.user.adapters.dtos.request_dto.CreateUserDTO;
import com.bloger.afonsonzango.api.features.user.adapters.dtos.response_dto.ResponseUserDTO;
import com.bloger.afonsonzango.api.features.user.adapters.dtos.response_mappers.UserResponseMapper;
import com.bloger.afonsonzango.api.features.user.domain.entities.User;
import com.bloger.afonsonzango.api.features.user.infrastructures.repositories.user_repository;
import com.bloger.afonsonzango.api.globals.exeptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {
    private final user_repository userRepository;

    @Autowired
    public CreateUserService(user_repository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseUserDTO registerUser(CreateUserDTO userRegister) throws ValidationException {
        try {
            if (!userRepository.findByEmail(userRegister.getEmail()).isEmpty()) {
                throw new ValidationException("Email já registrado no sistema");
            }

            User user = new User();

            user.setName(userRegister.getName());
            user.setEmail(userRegister.getEmail());
            user.setPassword(userRegister.getPassword());

            userRepository.save(user);

            return UserResponseMapper.user_response_mapper(user);
        } catch (ValidationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao registrar usuario!", ex);
        }
    }
}



























