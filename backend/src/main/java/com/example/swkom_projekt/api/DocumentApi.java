package com.example.swkom_projekt.api;

import com.example.swkom_projekt.service.DocumentService;
import com.example.swkom_projekt.service.dtos.DocumentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.swkom_projekt.service.factory.DocumentDtoFactory;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path="documents")
public class DocumentApi {

    @Autowired
    private DocumentService documentService;
    @Autowired
    private DocumentDtoFactory documentDtoFactory;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file) throws IOException {
        DocumentDto documentDto = documentDtoFactory.createFromMultipartFile(file);
        documentService.uploadDocument(documentDto);
        return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("Upload successful.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDocument(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
       DocumentDto documentDto = documentDtoFactory.createFromMultipartFile(file);
       documentService.updateDocument(id, documentDto);
       return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("Update successful.");
    }

    @GetMapping("/search")
    public ResponseEntity<String> searchDocuments() {
        return ResponseEntity.ok("Search endpoint is defined.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDto> getDocumentById(@PathVariable Long id) {
        DocumentDto documentDto = documentService.getDocumentById(id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(documentDto);
    }

    @GetMapping
    public ResponseEntity<List<DocumentDto>> getAllDocuments() {
        List<DocumentDto> documents = documentService.getAllDocuments();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(documents);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("Delete successful.");
    }
}
