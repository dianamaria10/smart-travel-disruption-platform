package com.smarttravel.smarttraveldisruptionplatform.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "disruption_event_id")
    private DisruptionEvent disruptionEvent;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private NotificationChannel channel;

    @Column(nullable = false)
    private String message;

    @Column(name = "sent_at", nullable = false, updatable = false)
    private LocalDateTime sentAt;

    @Column(name = "read_at")
    private LocalDateTime readAt;

    protected Notification() {
        // constructor gol, necesar de JPA/Hibernate
    }

    public Notification(User user, DisruptionEvent disruptionEvent, NotificationChannel channel, String message) {
        this.user = user;
        this.disruptionEvent = disruptionEvent;
        this.channel = channel;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public DisruptionEvent getDisruptionEvent() {
        return disruptionEvent;
    }

    public NotificationChannel getChannel() {
        return channel;
    }

    public void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public LocalDateTime getReadAt() {
        return readAt;
    }

    public void setReadAt(LocalDateTime readAt) {
        this.readAt = readAt;
    }

    @PrePersist
    protected void onCreate() {
        this.sentAt = LocalDateTime.now();
    }
}