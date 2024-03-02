package org.example.projectt.app.requests.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import jakarta.validation.constraints.Size;

@Data
@Schema(description = "запрос на вход администратору")
public class AdminLoginRequest {
    @Schema(description = "Email администратора", example = "admin@admin.com")
    @Size(min = 1, max = 100)
    private String email;

    @Schema(description = "Пароль администратора", example = "password")
    @Size(min = 8, max = 255)
    private String password;
}