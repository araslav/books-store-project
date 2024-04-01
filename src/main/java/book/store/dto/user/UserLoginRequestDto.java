package book.store.dto.user;

import book.store.validation.email.Email;
import jakarta.validation.constraints.NotBlank;

public record UserLoginRequestDto(
        @Email
        String login,
        @NotBlank(message = "Password can't be Null or Empty")
        String password) {

}
