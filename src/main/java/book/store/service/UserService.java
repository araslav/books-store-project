package book.store.service;

import book.store.dto.user.UserRegistrationRequestDto;
import book.store.dto.user.UserResponseDto;

public interface UserService {
    UserResponseDto save(UserRegistrationRequestDto user);

    boolean isIsset(String email);
}
