package book.store.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequestDto {
    @NotBlank(message = "Email can't be Null or Empty")
    private String email;
    @NotBlank(message = "Password can't be Null or Empty")
    private String password;
    @NotBlank(message = "Repeat password can't be Null or Empty")
    private String repeatPassword;
    @NotBlank(message = "First name can't be Null or Empty")
    private String firstName;
    @NotBlank(message = "Last name can't be Null or Empty")
    private String lastName;
    private String shippingAddress;
}
