package aeic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aeic.model.MessageTable;

public interface MessageRepository extends JpaRepository<MessageTable, Integer> {

}
