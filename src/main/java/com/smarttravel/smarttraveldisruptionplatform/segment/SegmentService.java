package com.smarttravel.smarttraveldisruptionplatform.segment;

import com.smarttravel.smarttraveldisruptionplatform.domain.Segment;
import com.smarttravel.smarttraveldisruptionplatform.domain.SegmentRepository;
import com.smarttravel.smarttraveldisruptionplatform.domain.SegmentStatus;
import com.smarttravel.smarttraveldisruptionplatform.domain.Trip;
import com.smarttravel.smarttraveldisruptionplatform.domain.TripRepository;
import com.smarttravel.smarttraveldisruptionplatform.trip.TripNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SegmentService {

    private final SegmentRepository segmentRepository;
    private final TripRepository tripRepository;

    public SegmentService(SegmentRepository segmentRepository, TripRepository tripRepository) {
        this.segmentRepository = segmentRepository;
        this.tripRepository = tripRepository;
    }

    public SegmentResponse createSegment(Long tripId, SegmentCreateRequest request) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new TripNotFoundException(tripId));

        Segment segment = new Segment(
                trip,
                request.getSequenceOrder(),
                request.getTransportType(),
                request.getReferenceCode(),
                request.getCarrierName(),
                request.getOrigin(),
                request.getDestination(),
                request.getScheduledDeparture(),
                request.getScheduledArrival(),
                SegmentStatus.ON_TIME
        );

        return SegmentResponse.fromEntity(segmentRepository.save(segment));
    }

    public List<SegmentResponse> getSegmentsByTrip(Long tripId) {
        if (!tripRepository.existsById(tripId)) {
            throw new TripNotFoundException(tripId);
        }
        return segmentRepository.findByTripIdOrderBySequenceOrderAsc(tripId).stream()
                .map(SegmentResponse::fromEntity)
                .toList();
    }

    public SegmentResponse getSegmentById(Long id) {
        Segment segment = segmentRepository.findById(id)
                .orElseThrow(() -> new SegmentNotFoundException(id));
        return SegmentResponse.fromEntity(segment);
    }

    public SegmentResponse updateSegment(Long id, SegmentUpdateRequest request) {
        Segment segment = segmentRepository.findById(id)
                .orElseThrow(() -> new SegmentNotFoundException(id));

        segment.setSequenceOrder(request.getSequenceOrder());
        segment.setTransportType(request.getTransportType());
        segment.setReferenceCode(request.getReferenceCode());
        segment.setCarrierName(request.getCarrierName());
        segment.setOrigin(request.getOrigin());
        segment.setDestination(request.getDestination());
        segment.setScheduledDeparture(request.getScheduledDeparture());
        segment.setScheduledArrival(request.getScheduledArrival());
        segment.setActualDeparture(request.getActualDeparture());
        segment.setActualArrival(request.getActualArrival());
        segment.setStatus(request.getStatus());

        return SegmentResponse.fromEntity(segmentRepository.save(segment));
    }

    public void deleteSegment(Long id) {
        if (!segmentRepository.existsById(id)) {
            throw new SegmentNotFoundException(id);
        }
        segmentRepository.deleteById(id);
    }
}