package book.store.service.impl;

import book.store.config.SecurityConfig;
import book.store.dto.user.UserRegistrationRequestDto;
import book.store.dto.user.UserResponseDto;
import book.store.mapper.UserMapper;
import book.store.model.User;
import book.store.repository.user.UserRepository;
import book.store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final SecurityConfig securityConfig;

    @Override
    public UserResponseDto save(UserRegistrationRequestDto userDto) {
        PasswordEncoder passwordEncoder = securityConfig.getPasswordEncoder();
        User user = userMapper.toModel(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public boolean isIsset(String email) {
        return userRepository.findByEmail(email).isEmpty();
    }
}
