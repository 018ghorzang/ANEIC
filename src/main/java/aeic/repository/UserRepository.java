package aeic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import aeic.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
           
           Optional<User> findByEmail(@Param("email") String email);
           
           //                Case Sensitive //
           @Query("SELECT u FROM User u WHERE u.email = :email")
           public User getUserByEmail(@Param("email") String email);
           
           long count();

		 @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);
  
}
