package aeic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aeic.model.Authentication;

public interface AutheticationRepsitory extends JpaRepository<Authentication, Integer> {

}
