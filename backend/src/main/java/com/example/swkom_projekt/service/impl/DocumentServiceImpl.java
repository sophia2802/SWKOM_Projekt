package com.example.swkom_projekt.service.impl;

import com.example.swkom_projekt.persistence.entities.DocumentEntity;
import com.example.swkom_projekt.persistence.repositories.DocumentRepository;
import com.example.swkom_projekt.service.DocumentService;
import com.example.swkom_projekt.service.dtos.DocumentDto;
import com.example.swkom_projekt.service.mapper.DocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public void uploadDocument(DocumentDto documentDto) throws IOException {
        DocumentEntity documentEntity = documentMapper.mapToEntity(documentDto);
        documentRepository.save(documentEntity);
    }

    @Override
    public void updateDocument(Long id, DocumentDto documentDto) {
        DocumentEntity existingDocument = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));

        DocumentEntity updatedDocument = documentMapper.mapToEntity(documentDto);
        updatedDocument.setId(existingDocument.getId());
        documentRepository.save(updatedDocument);
    }

   @Override
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }

    @Override
    public DocumentDto getDocumentById(Long id) {
        DocumentEntity documentEntity = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));
        return documentMapper.mapToDto(documentEntity);
    }

    @Override
    public List<DocumentDto> getAllDocuments() {
        return documentRepository.findAll().stream()
                .map(documentMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
