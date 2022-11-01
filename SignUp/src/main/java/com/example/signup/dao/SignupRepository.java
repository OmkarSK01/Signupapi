package com.example.signup.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.example.signup.dto.SignupDto;
import com.example.signup.model.Signup;

public interface SignupRepository extends JpaRepository<Signup, Long> {

	
	Optional<Signup> findByUserId(Long userId);

	

	Optional<Signup> findByContact(Long contact);
	

	
	


	

    Signup findByFirstName(String firstName);
    Optional<Signup> findByEmail(String email);
    
    
   
    Signup findByLastName(String lastName);
    
    Optional<Signup> findByUserName(String userName);
    Signup getByUserId(Long userId);



	
//    Optional<Users> findByUserId(Long userId);
//
//	Users findByFirstName(String firstName);
//
//	Users getByUserId(Long userId);
//
//	Users findByLastName(String lastName);
//
//	Optional<Users> findByEmail(String email);
//
//	Optional<Users> findByContact(Long contact);
//
//	Optional<Users> findByUserName(String userName);

	
}
	
	

	
	

	
	

	
	

