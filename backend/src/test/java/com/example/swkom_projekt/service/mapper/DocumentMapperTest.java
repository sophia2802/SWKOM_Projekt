package com.example.swkom_projekt.service.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.swkom_projekt.persistence.entities.DocumentEntity;
import com.example.swkom_projekt.service.dtos.DocumentDto;
import com.example.swkom_projekt.service.mapper.DocumentMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DocumentMapperTest {

    private DocumentMapper documentMapper;

    @BeforeEach
    public void setUp() {
        documentMapper = new DocumentMapper();
    }

    @Test
    public void testMapToDto() {
        DocumentEntity entity = DocumentEntity.builder()
                .id(1L)
                .name("Test Document")
                .description("Test Description")
                .size(500L)
                .type("application/pdf")
                .fileData(new byte[]{1, 2, 3})
                .uploadDate("2023-10-12")
                .build();

        DocumentDto dto = documentMapper.mapToDto(entity);

        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.getDescription(), dto.getDescription());
        assertEquals(entity.getSize(), dto.getSize());
        assertEquals(entity.getType(), dto.getType());
        assertEquals(entity.getUploadDate(), dto.getUploadDate());
    }

    @Test
    public void testMapToEntity() {
        DocumentDto dto = DocumentDto.builder()
                .id(1L)
                .name("Test Document")
                .description("Test Description")
                .size(500L)
                .type("application/pdf")
                .fileData(new byte[]{1, 2, 3})
                .uploadDate("2023-10-12")
                .build();

        DocumentEntity entity = documentMapper.mapToEntity(dto);

        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getName(), entity.getName());
        assertEquals(dto.getDescription(), entity.getDescription());
        assertEquals(dto.getSize(), entity.getSize());
        assertEquals(dto.getType(), entity.getType());
        assertEquals(dto.getUploadDate(), entity.getUploadDate());
    }
}
