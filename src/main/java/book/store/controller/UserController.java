package book.store.controller;

import book.store.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User controller", description = "Endpoint for managing users")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Delete User by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
