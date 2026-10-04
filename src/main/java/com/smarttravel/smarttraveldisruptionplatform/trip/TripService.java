package com.smarttravel.smarttraveldisruptionplatform.trip;

import com.smarttravel.smarttraveldisruptionplatform.domain.Trip;
import com.smarttravel.smarttraveldisruptionplatform.domain.TripRepository;
import com.smarttravel.smarttraveldisruptionplatform.domain.User;
import com.smarttravel.smarttraveldisruptionplatform.domain.UserRepository;
import com.smarttravel.smarttraveldisruptionplatform.user.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final UserRepository userRepository;

    public TripService(TripRepository tripRepository, UserRepository userRepository) {
        this.tripRepository = tripRepository;
        this.userRepository = userRepository;
    }

    public TripResponse createTrip(TripCreateRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException(request.getUserId()));

        Trip trip = new Trip(user, request.getTitle(), request.getStatus());
        return TripResponse.fromEntity(tripRepository.save(trip));
    }

    public TripResponse getTripById(Long id) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new TripNotFoundException(id));
        return TripResponse.fromEntity(trip);
    }

    public List<TripResponse> getAllTrips() {
        return tripRepository.findAll().stream()
                .map(TripResponse::fromEntity)
                .toList();
    }
    public TripResponse updateTrip(Long id, TripUpdateRequest request) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new TripNotFoundException(id));

        trip.setTitle(request.getTitle());
        trip.setStatus(request.getStatus());

        return TripResponse.fromEntity(tripRepository.save(trip));
    }

    public void deleteTrip(Long id) {
        if (!tripRepository.existsById(id)) {
            throw new TripNotFoundException(id);
        }
        tripRepository.deleteById(id);
    }
}