package book.store.validation.password;

import book.store.dto.user.UserRegistrationRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchersValidator implements
        ConstraintValidator<PasswordMatches, UserRegistrationRequestDto> {
    @Override
    public boolean isValid(UserRegistrationRequestDto dto,
                           ConstraintValidatorContext context) {
        return dto.password().equals(dto.repeatPassword());
    }
}
