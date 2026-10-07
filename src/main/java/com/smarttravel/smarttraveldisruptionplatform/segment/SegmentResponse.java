package com.smarttravel.smarttraveldisruptionplatform.segment;

import com.smarttravel.smarttraveldisruptionplatform.domain.Segment;
import com.smarttravel.smarttraveldisruptionplatform.domain.SegmentStatus;
import com.smarttravel.smarttraveldisruptionplatform.domain.TransportType;

import java.time.LocalDateTime;

public class SegmentResponse {

    private final Long id;
    private final Long tripId;
    private final Integer sequenceOrder;
    private final TransportType transportType;
    private final String referenceCode;
    private final String carrierName;
    private final String origin;
    private final String destination;
    private final LocalDateTime scheduledDeparture;
    private final LocalDateTime scheduledArrival;
    private final LocalDateTime actualDeparture;
    private final LocalDateTime actualArrival;
    private final SegmentStatus status;

    public SegmentResponse(Long id, Long tripId, Integer sequenceOrder, TransportType transportType,
                           String referenceCode, String carrierName, String origin, String destination,
                           LocalDateTime scheduledDeparture, LocalDateTime scheduledArrival,
                           LocalDateTime actualDeparture, LocalDateTime actualArrival, SegmentStatus status) {
        this.id = id;
        this.tripId = tripId;
        this.sequenceOrder = sequenceOrder;
        this.transportType = transportType;
        this.referenceCode = referenceCode;
        this.carrierName = carrierName;
        this.origin = origin;
        this.destination = destination;
        this.scheduledDeparture = scheduledDeparture;
        this.scheduledArrival = scheduledArrival;
        this.actualDeparture = actualDeparture;
        this.actualArrival = actualArrival;
        this.status = status;
    }

    public static SegmentResponse fromEntity(Segment segment) {
        return new SegmentResponse(
                segment.getId(),
                segment.getTrip().getId(),
                segment.getSequenceOrder(),
                segment.getTransportType(),
                segment.getReferenceCode(),
                segment.getCarrierName(),
                segment.getOrigin(),
                segment.getDestination(),
                segment.getScheduledDeparture(),
                segment.getScheduledArrival(),
                segment.getActualDeparture(),
                segment.getActualArrival(),
                segment.getStatus()
        );
    }

    public Long getId() {
        return id;
    }

    public Long getTripId() {
        return tripId;
    }

    public Integer getSequenceOrder() {
        return sequenceOrder;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public LocalDateTime getScheduledArrival() {
        return scheduledArrival;
    }

    public LocalDateTime getActualDeparture() {
        return actualDeparture;
    }

    public LocalDateTime getActualArrival() {
        return actualArrival;
    }

    public SegmentStatus getStatus() {
        return status;
    }
}