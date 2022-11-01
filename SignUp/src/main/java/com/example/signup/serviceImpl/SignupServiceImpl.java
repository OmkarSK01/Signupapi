package com.example.signup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.signup.dao.SignupRepository;
import com.example.signup.dto.SignupDto;
import com.example.signup.model.Signup;
import com.example.signup.service.SignupService;

@Service
public class SignupServiceImpl implements SignupService {      

	@Autowired
	private SignupRepository signupRepository;



	@Override
	public ResponseEntity<String> saveSignup(SignupDto signupDto) {
		Signup Signup = new Signup();
		
		Optional<Signup> userId = signupRepository.findById(signupDto.getUserId());
		if (!userId.isPresent()) {
		Signup.setUserId(signupDto.getUserId());
		} else {
		return new ResponseEntity<>("User id Not Available...", HttpStatus.OK);
	}
		
		// Check Firstname and Lastname available
				Optional<Signup> firstname = Optional.ofNullable(signupRepository.findByFirstName(signupDto.getFirstName()));
				Optional<Signup> lastname = Optional.ofNullable(signupRepository.findByLastName(signupDto.getLastName()));
				if (!firstname.isPresent() && !lastname.isPresent()) {

					Signup.setFirstName(signupDto.getFirstName());
					Signup.setFirstName(signupDto.getFirstName());
				}
		
		// Check Username available
				Optional<Signup> username = signupRepository.findByUserName(signupDto.getUserName());
				if (!username.isPresent()) {

					Signup.setUserName(signupDto.getUserName());
				} else {
					return new ResponseEntity<>("Username Not Available...", HttpStatus.OK);
				}
		
		
		// Check Email is Present
				Optional<Signup> email = signupRepository.findByEmail(signupDto.getEmail());
				System.out.println(email);
				if (!email.isPresent()) {

					Signup.setEmail(signupDto.getEmail());
				} else {
					return new ResponseEntity<>("Email Already Used...", HttpStatus.OK);
				}
		
		
		
		
		// Check Contact Available

		Optional<Signup> contact = signupRepository.findByContact(signupDto.getContact());
		if (!contact.isPresent()) {
		Signup.setFirstName(signupDto.getFirstName());              //for post the data or for record save

		Signup.setLastName(signupDto.getLastName());
		Signup.setUserName(signupDto.getUserName());
		Signup.setEmail(signupDto.getEmail());
		Signup.setContact(signupDto.getContact());
		Signup.setPassword(signupDto.getPassword());
		Signup.setDob(signupDto.getDob());
		signupRepository.save(Signup);
		return new ResponseEntity<>("User Registered Successfully...", HttpStatus.OK); //for record save
		
	} else {
		

		return new ResponseEntity<>("Contact Already Registered....", HttpStatus.OK);
	}
}
	
	
	@Override
	public List<Signup>listAll(){
		return signupRepository.findAll();
	}

   
	@Override
	public Optional<Signup> getUser(Long userId) {
	return signupRepository.findByUserId(userId);
	

	}


	


	// Update By UserId
		@Override
		public ResponseEntity<String> updateSignup(Long userId, SignupDto signupDto) {
			ResponseEntity<String> msg = new ResponseEntity<>("", HttpStatus.OK);
			Optional<Signup> value = signupRepository.findById(userId);
			if (value.isPresent()) {
				Signup signup = signupRepository.getByUserId(userId);
				signup.setFirstName(signupDto.getFirstName());
				signup.setLastName(signupDto.getLastName());
				signup.setDob(signupDto.getDob());
				signupRepository.save(signup);
				msg = new ResponseEntity<>("User Data Updated Successfully... ", HttpStatus.OK);
			} else {
				msg = new ResponseEntity<>("User Not Exist...", HttpStatus.OK);
			}
			return msg;
		}


	@Override
	public Optional<Signup> getByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(signupRepository.findByFirstName(firstName));
	
	}


	
	


	@Override
	public Optional<Signup> getByUserId(Long userId) {
		// TODO Auto-generated method stub
		return signupRepository.findById(userId);
	}


	@Override
	public Optional<Signup> getByLastName(String lastName) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(signupRepository.findByLastName(lastName));
	}


	
	
}





















