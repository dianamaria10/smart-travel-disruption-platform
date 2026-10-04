package com.smarttravel.smarttraveldisruptionplatform.trip;

import com.smarttravel.smarttraveldisruptionplatform.domain.TripStatus;
import jakarta.validation.constraints.NotNull;

public class TripCreateRequest {

    @NotNull(message = "User id is required")
    private Long userId;

    private String title;

    @NotNull(message = "Status is required")
    private TripStatus status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }
}