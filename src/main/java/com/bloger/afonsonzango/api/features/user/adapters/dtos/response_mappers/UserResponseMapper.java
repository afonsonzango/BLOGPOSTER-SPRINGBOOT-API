package com.bloger.afonsonzango.api.features.user.adapters.dtos.response_mappers;

import com.bloger.afonsonzango.api.features.user.adapters.dtos.response_dto.ResponseUserDTO;
import com.bloger.afonsonzango.api.features.user.domain.entities.User;

public class UserResponseMapper {
    public static ResponseUserDTO user_response_mapper(User user) {
        ResponseUserDTO dto = new ResponseUserDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        return dto;
    }
}
