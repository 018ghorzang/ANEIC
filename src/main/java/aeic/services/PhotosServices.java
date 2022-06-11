package aeic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeic.model.PhotosModel;
import aeic.repository.PhotosRepository;

@Service
public class PhotosServices {
	
	@Autowired
	private PhotosRepository pthRepository;
	
	
	public List<PhotosModel> getPhotos(){
		
		return pthRepository.findAll();
	}

}
