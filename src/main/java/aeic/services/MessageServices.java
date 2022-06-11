package aeic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeic.model.MessageTable;
import aeic.repository.MessageRepository;

@Service
public class MessageServices {

	@Autowired
	MessageRepository messagesRepository;
	
	
	public void messagesSave(MessageTable message) {
		messagesRepository.save(message);
	}
	
	public void messageDeleteById(Integer id) {

		messagesRepository.deleteById(id);
	}
	
	public List<MessageTable> getAll(){
	 return 	messagesRepository.findAll();
	}


	
	
}
