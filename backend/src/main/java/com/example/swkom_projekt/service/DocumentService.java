package com.example.swkom_projekt.service;

import com.example.swkom_projekt.service.dtos.DocumentDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DocumentService {

    void uploadDocument(MultipartFile file) throws IOException;

    /*void updateDocument(Long id, DocumentDto documentDto);

    void deleteDocument(Long id);

    DocumentDto getDocumentById(Long id);

    List<DocumentDto> getAllDocuments();*/
}
