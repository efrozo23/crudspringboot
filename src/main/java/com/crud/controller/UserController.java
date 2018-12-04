package com.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.exception.ResourceNotFoundException;
import com.crud.model.User;
import com.crud.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired(required = true)
	UserRepository userRepository;

	// Get all user
	@GetMapping("/alluser")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	// Create user
	@PostMapping("/saveUser")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);

	}

	// Get user by id
	@GetMapping("/getById/{id}")
	public User getUserById(@PathVariable(value = "id") Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
	}

	// Edit user
	@PutMapping("/userEdit/{id}")
	public User editUser(@PathVariable(value = "id") Long id, @Valid @RequestBody User userDetails) {
		User u = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		u.setNameUser(userDetails.getEmailUser());
		u.setLastnameUser(userDetails.getLastnameUser());
		u.setUsernameUser(userDetails.getUsernameUser());
		u.setEmailUser(userDetails.getEmailUser());
		User userUpdate = userRepository.save(u);
		return userUpdate;

	}

	// Delete user
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long idUser) {
		User u = userRepository.findById(idUser).orElseThrow(() -> new ResourceNotFoundException("User", "Id", idUser));

		userRepository.delete(u);
		return ResponseEntity.ok().build();
	}

	// Test jpql
	@GetMapping("/getByEmail/{email}")
	public User getByEmail(@PathVariable(value = "email") String email) {
		return userRepository.getByEmail(email);
	}

}
