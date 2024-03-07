package book.store.dto.user;

import book.store.validation.email.Email;
import book.store.validation.email.UniqueEmail;
import book.store.validation.password.PasswordMatches;
import jakarta.validation.constraints.NotBlank;

@PasswordMatches
public record UserRegistrationRequestDto(
        @Email
        String email,
        @NotBlank(message = "Password can't be Null or Empty")
        String password,
        @NotBlank(message = "Repeat password can't be Null or Empty")
        String repeatPassword,
        @NotBlank(message = "First name can't be Null or Empty")
        String firstName,
        @NotBlank(message = "Last name can't be Null or Empty")
        String lastName,
        String shippingAddress) {
}
