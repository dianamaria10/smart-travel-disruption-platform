package com.smarttravel.smarttraveldisruptionplatform.segment;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SegmentController {

    private final SegmentService segmentService;

    public SegmentController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    @PostMapping("/trips/{tripId}/segments")
    public ResponseEntity<SegmentResponse> createSegment(@PathVariable Long tripId,
                                                         @Valid @RequestBody SegmentCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(segmentService.createSegment(tripId, request));
    }

    @GetMapping("/trips/{tripId}/segments")
    public ResponseEntity<List<SegmentResponse>> getSegmentsByTrip(@PathVariable Long tripId) {
        return ResponseEntity.ok(segmentService.getSegmentsByTrip(tripId));
    }

    @GetMapping("/segments/{id}")
    public ResponseEntity<SegmentResponse> getSegmentById(@PathVariable Long id) {
        return ResponseEntity.ok(segmentService.getSegmentById(id));
    }

    @PutMapping("/segments/{id}")
    public ResponseEntity<SegmentResponse> updateSegment(@PathVariable Long id,
                                                         @Valid @RequestBody SegmentUpdateRequest request) {
        return ResponseEntity.ok(segmentService.updateSegment(id, request));
    }

    @DeleteMapping("/segments/{id}")
    public ResponseEntity<Void> deleteSegment(@PathVariable Long id) {
        segmentService.deleteSegment(id);
        return ResponseEntity.noContent().build();
    }
}