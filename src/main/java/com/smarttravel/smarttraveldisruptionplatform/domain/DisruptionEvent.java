package com.smarttravel.smarttraveldisruptionplatform.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "disruption_events")
public class DisruptionEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "segment_id", nullable = false)
    private Segment segment;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false, length = 20)
    private EventType eventType;

    @Column(name = "delay_minutes")
    private Integer delayMinutes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Severity severity;

    @Column(name = "detected_at", nullable = false, updatable = false)
    private LocalDateTime detectedAt;

    @Column
    private String description;

    protected DisruptionEvent() {
        // constructor gol, necesar de JPA/Hibernate
    }

    public DisruptionEvent(Segment segment, EventType eventType, Integer delayMinutes,
                           Severity severity, String description) {
        this.segment = segment;
        this.eventType = eventType;
        this.delayMinutes = delayMinutes;
        this.severity = severity;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Segment getSegment() {
        return segment;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Integer getDelayMinutes() {
        return delayMinutes;
    }

    public void setDelayMinutes(Integer delayMinutes) {
        this.delayMinutes = delayMinutes;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @PrePersist
    protected void onCreate() {
        this.detectedAt = LocalDateTime.now();
    }
}