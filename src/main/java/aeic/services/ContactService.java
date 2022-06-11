package aeic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeic.model.Authentication;
import aeic.model.MessageTable;
import aeic.repository.AutheticationRepsitory;
import aeic.repository.MessageRepository;

@Service
public class ContactService {
	
	/* Inherited  from Message & Authentication interfaces */
	
	@Autowired
	private AutheticationRepsitory authenticationRepo;
	
	@Autowired
	private MessageRepository messageRep;

	
	
	public List<Authentication> getAuthentication(){
		
		return authenticationRepo.findAll();
	}
	
	
	public List<MessageTable> getMessage(){
		return messageRep.findAll();
	}
	
	/* Save the data */
	
	/*  Authentication */
	public void saveAuthentication(Authentication auth) {
		authenticationRepo.save(auth);
		
	}
	
	/*  Message */
	public void saveMessage(MessageTable message) {
		messageRep.save(message);
		
	}
}
