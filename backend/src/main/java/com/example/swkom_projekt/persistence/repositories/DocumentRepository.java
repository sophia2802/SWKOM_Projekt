package com.example.swkom_projekt.persistence.repositories;

import com.example.swkom_projekt.persistence.entities.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {
}
