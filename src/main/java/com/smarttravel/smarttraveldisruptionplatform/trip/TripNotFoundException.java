package com.smarttravel.smarttraveldisruptionplatform.trip;

public class TripNotFoundException extends RuntimeException {

    public TripNotFoundException(Long id) {
        super("Trip not found with id: " + id);
    }
}