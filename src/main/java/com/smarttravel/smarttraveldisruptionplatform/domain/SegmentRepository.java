package com.smarttravel.smarttraveldisruptionplatform.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SegmentRepository extends JpaRepository<Segment, Long> {

    List<Segment> findByTripIdOrderBySequenceOrderAsc(Long tripId);
}