package com.bloger.afonsonzango.api.features.user.adapters.dtos.request_dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UpdateUserDTO {
    @Length(min = 10, max = 55, message = "Nome requer 10 no minimo e 55 no maximo")
    private String name;

    @Email(message = "Email invalido")
    private String email;

    @Length(min = 8, max = 32, message = "Senha deve ter no mino 8n ncaracteres e no maximo 32")
    private String password;
}