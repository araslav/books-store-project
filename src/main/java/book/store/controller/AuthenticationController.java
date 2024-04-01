package book.store.controller;

import book.store.dto.user.UserLoginRequestDto;
import book.store.dto.user.UserLoginResponseDTO;
import book.store.dto.user.UserRegistrationRequestDto;
import book.store.dto.user.UserResponseDto;
import book.store.security.AuthenticationService;
import book.store.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication controller", description = "Endpoint for registration users")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @Operation(summary = "Register a new Book",
            parameters = {
                    @Parameter(name = "email", required = true,
                            description = "User's email, unique",
                            schema = @Schema(type = "string")),
                    @Parameter(name = "password", required = true,
                            description = "Password",
                            schema = @Schema(type = "string")),
                    @Parameter(name = "repeatPassword", required = true,
                            description = "Repeat password, should equals password",
                            schema = @Schema(type = "string")),
                    @Parameter(name = "firstName", required = true,
                            description = "User's first name",
                            schema = @Schema(type = "string")),
                    @Parameter(name = "lastName", required = true,
                            description = "User's last name",
                            schema = @Schema(type = "string")),
                    @Parameter(name = "shippingAddress",
                            description = "User's address for shipping",
                            schema = @Schema(type = "string"))})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/registration")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto request) {
        return userService.save(request);
    }

    @PostMapping("/login")
    public UserLoginResponseDTO login(@RequestBody @Valid UserLoginRequestDto request) {
        return authenticationService.authenticate(request);
    }
}
