package com.smarttravel.smarttraveldisruptionplatform.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "segments", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"trip_id", "sequence_order"})
})
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @Column(name = "sequence_order", nullable = false)
    private Integer sequenceOrder;

    @Enumerated(EnumType.STRING)
    @Column(name = "transport_type", nullable = false, length = 20)
    private TransportType transportType;

    @Column(name = "reference_code", length = 50)
    private String referenceCode;

    @Column(name = "carrier_name")
    private String carrierName;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @Column(name = "scheduled_departure", nullable = false)
    private LocalDateTime scheduledDeparture;

    @Column(name = "scheduled_arrival", nullable = false)
    private LocalDateTime scheduledArrival;

    @Column(name = "actual_departure")
    private LocalDateTime actualDeparture;

    @Column(name = "actual_arrival")
    private LocalDateTime actualArrival;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SegmentStatus status;

    protected Segment() {
        // constructor gol, necesar de JPA/Hibernate
    }

    public Segment(Trip trip, Integer sequenceOrder, TransportType transportType,
                   String referenceCode, String carrierName, String origin, String destination,
                   LocalDateTime scheduledDeparture, LocalDateTime scheduledArrival, SegmentStatus status) {
        this.trip = trip;
        this.sequenceOrder = sequenceOrder;
        this.transportType = transportType;
        this.referenceCode = referenceCode;
        this.carrierName = carrierName;
        this.origin = origin;
        this.destination = destination;
        this.scheduledDeparture = scheduledDeparture;
        this.scheduledArrival = scheduledArrival;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Trip getTrip() {
        return trip;
    }

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