package aeic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeic.controller.read;
import aeic.model.MapsModel;
import aeic.repository.MapsRepository;

@Service
public class MapsService {
	
	@Autowired
	MapsRepository mapsRepository;
	
	
	public List<MapsModel> getAll() {
	return	mapsRepository.findAll();
	}
	
	public void saveMap(MapsModel maps) {
		mapsRepository.save(maps);
	}
	
	public void deleteMap(Integer id) {
		mapsRepository.deleteById(id);
	}
	
	public Optional<MapsModel> findById(Integer id){
		return mapsRepository.findById(id);
	}
	
	

}
