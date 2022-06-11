package aeic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeic.model.DocumentModel;
import aeic.model.NewsModel;
import aeic.repository.NewsRepository;

@Service
public class NewsServices {

	
	@Autowired
	NewsRepository newsRepository;
	
	
	
	public void saveNews(NewsModel news) {
		newsRepository.save(news);	
	}

	public List<NewsModel> getAll() {
		return newsRepository.findAll();
	}

	public void delete(Long id) {
		newsRepository.deleteById(id);	
	}

    public Optional<NewsModel> findById(Long id) {
		return newsRepository.findById(id);
	}
	
}
