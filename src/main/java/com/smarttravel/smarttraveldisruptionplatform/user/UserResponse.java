package com.smarttravel.smarttraveldisruptionplatform.user;

import com.smarttravel.smarttraveldisruptionplatform.domain.User;
import com.smarttravel.smarttraveldisruptionplatform.domain.UserRole;

import java.time.LocalDateTime;

public class UserResponse {

    private Long id;
    private String email;
    private String fullName;
    private UserRole role;
    private LocalDateTime createdAt;

    public UserResponse(Long id, String email, String fullName, UserRole role, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
        this.createdAt = createdAt;
    }

    public static UserResponse fromEntity(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getFullName(),
                user.getRole(),
                user.getCreatedAt()
        );
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRole getRole() {
        return role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}