package com.smarttravel.smarttraveldisruptionplatform.user;

import com.smarttravel.smarttraveldisruptionplatform.domain.User;
import com.smarttravel.smarttraveldisruptionplatform.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(UserCreateRequest request) {
        String passwordHash = hashPassword(request.getPassword());

        User user = new User(
                request.getEmail(),
                passwordHash,
                request.getFullName(),
                request.getRole()
        );

        User savedUser = userRepository.save(user);
        return UserResponse.fromEntity(savedUser);
    }
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return UserResponse.fromEntity(user);
    }

    private String hashPassword(String rawPassword) {
        // TODO: înlocuim cu BCrypt când adăugăm Spring Security
        return "TEMP_HASH_" + rawPassword;
    }
}