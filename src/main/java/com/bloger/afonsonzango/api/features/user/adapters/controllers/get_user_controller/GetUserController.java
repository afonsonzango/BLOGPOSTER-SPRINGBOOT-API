package com.bloger.afonsonzango.api.features.user.adapters.controllers.get_user_controller;

import com.bloger.afonsonzango.api.features.user.adapters.dtos.response_dto.ResponseUserDTO;
import com.bloger.afonsonzango.api.features.user.application.get_user.GetUserService;
import com.bloger.afonsonzango.api.globals.application.dtos.response_dtos.APIResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.version}/users")
public class GetUserController {
    private final GetUserService getUserService;

    @Autowired
    public GetUserController (GetUserService getUserService) {
        this.getUserService = getUserService;
    }

    @GetMapping("/all")
    public APIResponseDTO<List<ResponseUserDTO>> getAllUsers () {
        try {
            List<ResponseUserDTO> users = getUserService.getAllUsers();
            return new APIResponseDTO<>(false, HttpStatus.FOUND, "Usuarios buscados com sucesso", users);
        } catch (Exception ex) {
            return new APIResponseDTO<>(true, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
        }
    }
}
