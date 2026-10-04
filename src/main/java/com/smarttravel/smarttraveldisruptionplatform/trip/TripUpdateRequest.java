package com.smarttravel.smarttraveldisruptionplatform.trip;

import com.smarttravel.smarttraveldisruptionplatform.domain.TripStatus;
import jakarta.validation.constraints.NotNull;

public class TripUpdateRequest {

    private String title;

    @NotNull(message = "Status is required")
    private TripStatus status;

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