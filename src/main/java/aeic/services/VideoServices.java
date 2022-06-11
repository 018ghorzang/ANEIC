package aeic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeic.model.VideoModel;
import aeic.repository.VideoRepository;

@Service
public class VideoServices {

	
	@Autowired
	VideoRepository videoRepository;
	
	
	
	public void saveVideo(VideoModel video) {
		videoRepository.save(video);	
	}

	public List<VideoModel> getAll() {
		return videoRepository.findAll();
	}

	public void delete(Long id) {
		videoRepository.deleteById(id);	
	}

    public Optional<VideoModel> findById(Long id) {
		return videoRepository.findById(id);
	}
	
}
