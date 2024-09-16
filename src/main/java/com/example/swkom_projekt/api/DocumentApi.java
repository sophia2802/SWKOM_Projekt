package com.example.swkom_projekt.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="documents")
public class DocumentApi {
    // Endpoints hardcoded

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument() {
        return ResponseEntity.ok("Upload endpoint is defined.");
    }

    @GetMapping("/search")
    public ResponseEntity<String> searchDocuments() {
        return ResponseEntity.ok("Search endpoint is defined.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getDocument(@PathVariable String id) {
        return ResponseEntity.ok("Get document endpoint is defined");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDocument(@PathVariable String id) {
        return ResponseEntity.ok("Update endpoint is defined");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable String id) {
        return ResponseEntity.ok("Delete endpoint is defined");
    }

    @GetMapping("/{id}/ocr-status")
    public ResponseEntity<String> getOcrStatus(@PathVariable String id) {
        return ResponseEntity.ok("OCR status endpoint is defined");
    }
}
