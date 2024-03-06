package book.store.controller;

import book.store.dto.user.UserRegistrationRequestDto;
import book.store.dto.user.UserResponseDto;
import book.store.exeption.RegistrationException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/registeration")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto request) throws RegistrationException {

        return null;
    }
}
