package aeic.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import aeic.model.NewsModel;

public interface NewsRepository extends JpaRepository<NewsModel, Long>{

	
	
}

