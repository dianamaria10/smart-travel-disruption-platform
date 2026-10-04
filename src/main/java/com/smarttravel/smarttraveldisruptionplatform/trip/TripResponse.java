package com.smarttravel.smarttraveldisruptionplatform.trip;

import com.smarttravel.smarttraveldisruptionplatform.domain.Trip;
import com.smarttravel.smarttraveldisruptionplatform.domain.TripStatus;

import java.time.LocalDateTime;

public class TripResponse {

    private final Long id;
    private final Long userId;
    private final String title;
    private final TripStatus status;
    private final LocalDateTime createdAt;

    public TripResponse(Long id, Long userId, String title, TripStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.status = status;
        this.createdAt = createdAt;
    }

    public static TripResponse fromEntity(Trip trip) {
        return new TripResponse(
                trip.getId(),
                trip.getUser().getId(),
                trip.getTitle(),
                trip.getStatus(),
                trip.getCreatedAt()
        );
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public TripStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}