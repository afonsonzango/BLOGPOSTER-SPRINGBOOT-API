package com.bloger.afonsonzango.api.features.user.adapters.dtos.request_dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateUserDTO {
    @NotBlank(message = "Ao criar conta, nome eh obrigatorio")
    @Length(max = 55, min = 10, message = "Nome deve ter entre 10 e 55 caracteres.")
    private String name;

    @NotBlank(message = "Email eh um campo obrigatorio")
    @Email(message = "Email invalido")
    private String email;

    @NotBlank(message = "Password eh um campo orbrigatorio")
    @Length(min = 8, message = "Sua senha deve ter no minimo 8 caracteres")
    @Length(max = 32, message = "Sua senha deve ter no maximo 8 caracteres")
    private String password;
}
