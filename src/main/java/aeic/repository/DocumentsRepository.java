package aeic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aeic.model.DocumentModel;

public interface DocumentsRepository extends JpaRepository<DocumentModel, Long>{



}
