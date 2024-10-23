package com.example.swkom_projekt.service.factory;

import com.example.swkom_projekt.service.dtos.DocumentDto;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface DocumentDtoFactory {
    DocumentDto createFromMultipartFile(MultipartFile file) throws IOException;
}
