package com.smarttravel.smarttraveldisruptionplatform.segment;

import com.smarttravel.smarttraveldisruptionplatform.domain.SegmentStatus;
import com.smarttravel.smarttraveldisruptionplatform.domain.TransportType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public class SegmentUpdateRequest {

    @NotNull(message = "Sequence order is required")
    @Positive(message = "Sequence order must be positive")
    private Integer sequenceOrder;

    @NotNull(message = "Transport type is required")
    private TransportType transportType;

    private String referenceCode;

    private String carrierName;

    @NotBlank(message = "Origin is required")
    private String origin;

    @NotBlank(message = "Destination is required")
    private String destination;

    @NotNull(message = "Scheduled departure is required")
    private LocalDateTime scheduledDeparture;

    @NotNull(message = "Scheduled arrival is required")
    private LocalDateTime scheduledArrival;

    private LocalDateTime actualDeparture;

    private LocalDateTime actualArrival;

    @NotNull(message = "Status is required")
    private SegmentStatus status;

    public Integer getSequenceOrder() {
        return sequenceOrder;
    }

    public void setSequenceOrder(Integer sequenceOrder) {
        this.sequenceOrder = sequenceOrder;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(LocalDateTime scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public LocalDateTime getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(LocalDateTime scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public LocalDateTime getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(LocalDateTime actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    public LocalDateTime getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(LocalDateTime actualArrival) {
        this.actualArrival = actualArrival;
    }

    public SegmentStatus getStatus() {
        return status;
    }

    public void setStatus(SegmentStatus status) {
        this.status = status;
    }
}