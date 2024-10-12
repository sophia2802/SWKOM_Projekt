package com.example.swkom_projekt.service.mapper;

import com.example.swkom_projekt.persistence.entities.DocumentEntity;
import com.example.swkom_projekt.service.dtos.DocumentDto;
import org.springframework.stereotype.Component;

@Component
public class DocumentMapper {

    // Mapt DocumentEntity auf DocumentDto
    public DocumentDto mapToDto(DocumentEntity source) {
        return DocumentDto.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .type(source.getType())
                .size(source.getSize())
                .uploadDate(source.getUploadDate())
                .fileData(source.getFileData())
                .build();
    }

    // Mapt DocumentDto auf DocumentEntity
    public DocumentEntity mapToEntity(DocumentDto source) {
        return DocumentEntity.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .type(source.getType())
                .size(source.getSize())
                .uploadDate(source.getUploadDate())
                .fileData(source.getFileData())
                .build();
    }
}