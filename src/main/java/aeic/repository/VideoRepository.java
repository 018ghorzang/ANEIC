package aeic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aeic.model.VideoModel;

public interface VideoRepository extends JpaRepository<VideoModel, Long>{

}
