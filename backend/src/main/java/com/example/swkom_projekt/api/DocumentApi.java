package com.example.swkom_projekt.api;

import com.example.swkom_projekt.service.DocumentService;
import com.example.swkom_projekt.service.dtos.DocumentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path="documents")
public class DocumentApi {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file) throws IOException {
        documentService.uploadDocument(file);
        return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("Upload successful.");
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
}
