package com.example.signup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.signup.dto.SignupDto;
import com.example.signup.model.Signup;

public interface SignupService {

	ResponseEntity<String> saveSignup(SignupDto signupDto);

	

	List<Signup> listAll();  //findby all



	Optional<Signup> getUser(Long userId);  //find by userid 
	Optional<Signup> getByFirstName(String firstName);
	Optional<Signup> getByLastName(String lastName);
	Optional<Signup> getByUserId(Long userId);



	



	





	



	ResponseEntity<String> updateSignup(Long userId, SignupDto signupDto);

}



	//ResponseEntity<String> updateSignup(Long userId);



	
		


	
//	ResponseEntity<String> saveUser(CrudDto crudDto);
//
//	List<Users> getData(Users users);
//
//	Optional<Users> getByFirstName(String firstName);
//
//	Optional<Users> getByLastName(String lastName);
//
//	Optional<Users> getByUserId(Long userId);
//
//	ResponseEntity<String> updateUser(Long userId, CrudDto crudDto);
//
//	ResponseEntity<String> deleteUser(Long userId);
	
		


	

	

