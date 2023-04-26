package br.com.motocode.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserPostRequestBody {
    @NotEmpty(message = "The user name cannot empty")
    private String name;

    @NotEmpty(message = "The user email cannot empty")
    private String email;

    @NotEmpty(message = "The user password cannot empty")
    private String password;
}
