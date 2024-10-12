package com.example.swkom_projekt.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDto {
    private Long id;
    private String name;
    private String description;
    private String type;
    private Long size;
    private String uploadDate;
    private byte[] fileData;
}
