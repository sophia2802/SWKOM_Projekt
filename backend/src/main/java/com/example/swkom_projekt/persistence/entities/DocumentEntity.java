package com.example.swkom_projekt.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "document")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Long size;

    @Column(nullable = false)
    private String uploadDate;

    @Lob // Markierung für große Objekte, um Dateien zu speichern
    @Column(nullable = false)
    private byte[] fileData;
}
