package com.example.cinema.service.impl;

import com.example.cinema.dto.UserRegisterDTO;
import com.example.cinema.entity.User;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // <-- Giữ lại dòng này
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // XÓA BỎ HOÀN TOÀN CONSTRUCTOR Ở ĐÂY

    @Override
    public void register(UserRegisterDTO dto) {
        if (userRepository.existsByUsername(dto.getUsername()) || userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole("ROLE_USER"); // Gán vai trò mặc định cho người dùng mới
        userRepository.save(user);
    }
}