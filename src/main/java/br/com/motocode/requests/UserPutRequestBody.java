package br.com.motocode.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserPutRequestBody {
    private Long id;

    @NotEmpty(message = "The user name cannot empty")
    @NotNull(message = "The user name cannot null")
    private String name;

    @NotEmpty(message = "The user email cannot empty")
    @NotNull(message = "The user email cannot null")
    private String email;

    @NotEmpty(message = "The user password cannot empty")
    @NotNull(message = "The user password cannot null")
    private String password;
}
