package com.example.swkom_projekt.service.factory;

import com.example.swkom_projekt.service.factory.DocumentDtoFactory;
import com.example.swkom_projekt.service.dtos.DocumentDto;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.IOException;

@Component
public class DocumentDtoFactoryImpl implements DocumentDtoFactory {

    @Override
    public DocumentDto createFromMultipartFile(MultipartFile file) throws IOException {
        return DocumentDto.builder()
                .name(file.getOriginalFilename())
                .description("Uploaded file: " + file.getOriginalFilename())
                .type(file.getContentType())
                .size(file.getSize())
                .uploadDate(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .fileData(file.getBytes())
                .build();
    }
}
