package com.bloger.afonsonzango.api.features.user.adapters.controllers.create_user_controller;

import com.bloger.afonsonzango.api.features.user.adapters.dtos.request_dto.CreateUserDTO;
import com.bloger.afonsonzango.api.features.user.adapters.dtos.response_dto.ResponseUserDTO;
import com.bloger.afonsonzango.api.features.user.application.create_user.CreateUserService;
import com.bloger.afonsonzango.api.globals.application.dtos.response_dtos.APIResponseDTO;
import com.bloger.afonsonzango.api.globals.exeptions.ValidationException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.version}/users")
public class CreateUserController {
    private final CreateUserService createUserService;

    @Autowired
    public CreateUserController (CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @PostMapping("/create")
    public APIResponseDTO<ResponseUserDTO> registerNewUser(@Valid @RequestBody CreateUserDTO createUserDTO, HttpServletRequest request) throws ValidationException {
        try {
            if (request.getContentLength() < 1) {
                return new APIResponseDTO<>(true, HttpStatus.BAD_REQUEST, "Todos os dados sao obrigatorios!", null);
            }

            ResponseUserDTO responseUserDTO = createUserService.registerUser(createUserDTO);
            return new APIResponseDTO<>(false, HttpStatus.CREATED, "Usuario criado com sucesso!", responseUserDTO);
        } catch (ValidationException ex) {
            return new APIResponseDTO<>(true, HttpStatus.BAD_REQUEST, ex.getMessage(), null);
        } catch (Exception ex) {
            return new APIResponseDTO<>(true, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
        }
    }
}