package com.smarttravel.smarttraveldisruptionplatform.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "alternative_options")
public class AlternativeOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "disruption_event_id", nullable = false)
    private DisruptionEvent disruptionEvent;

    @Column(nullable = false)
    private String description;

    @Column(name = "estimated_cost", precision = 10, scale = 2)
    private BigDecimal estimatedCost;

    @Column(name = "estimated_duration_minutes")
    private Integer estimatedDurationMinutes;

    @Column(name = "priority_score", nullable = false)
    private Integer priorityScore;

    @Column(name = "is_selected", nullable = false)
    private boolean selected = false;

    protected AlternativeOption() {
        // constructor gol, necesar de JPA/Hibernate
    }

    public AlternativeOption(DisruptionEvent disruptionEvent, String description, BigDecimal estimatedCost,
                             Integer estimatedDurationMinutes, Integer priorityScore) {
        this.disruptionEvent = disruptionEvent;
        this.description = description;
        this.estimatedCost = estimatedCost;
        this.estimatedDurationMinutes = estimatedDurationMinutes;
        this.priorityScore = priorityScore;
    }

    public Long getId() {
        return id;
    }

    public DisruptionEvent getDisruptionEvent() {
        return disruptionEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(BigDecimal estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public Integer getEstimatedDurationMinutes() {
        return estimatedDurationMinutes;
    }

    public void setEstimatedDurationMinutes(Integer estimatedDurationMinutes) {
        this.estimatedDurationMinutes = estimatedDurationMinutes;
    }

    public Integer getPriorityScore() {
        return priorityScore;
    }

    public void setPriorityScore(Integer priorityScore) {
        this.priorityScore = priorityScore;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}