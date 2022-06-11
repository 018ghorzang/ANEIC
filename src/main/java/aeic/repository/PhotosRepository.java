package aeic.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import aeic.model.PhotosModel;


public interface PhotosRepository extends JpaRepository<PhotosModel, Integer>{

}
