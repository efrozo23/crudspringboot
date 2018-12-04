package com.crud.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.crud.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.emailUser=:email")
	User getByEmail(@Param("email") String email);
}
