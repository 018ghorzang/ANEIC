package aeic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeic.model.DocumentModel;
import aeic.repository.DocumentsRepository;

@Service
public class DocumentsServices {
	
	@Autowired
	DocumentsRepository documentRepository;

	public void saveDocument(DocumentModel document) {
		documentRepository.save(document);
		
	}

	public List<DocumentModel> getAll() {
		// TODO Auto-generated method stub
		return documentRepository.findAll();
	}

	public void delete(Long id) {
		documentRepository.deleteById(id);
		
	}

	public Optional<DocumentModel> findById(Long id) {
		
		return documentRepository.findById(id);
	}

}
