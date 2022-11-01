package com.example.signup.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.signup.dto.SignupDto;
import com.example.signup.model.Signup;
import com.example.signup.service.SignupService;



@RestController
public class SignupController {

@Autowired
private SignupService signupService;


@PostMapping("/signUp")
public ResponseEntity<String> save(@RequestBody SignupDto signupDto){
	
return signupService.saveSignup(signupDto);
}


@GetMapping("/getData")
public List<Signup> list(){

return signupService.listAll();
}




@GetMapping("/findByUserId/{userId}")
public Optional<Signup> getUser(@PathVariable("userId") Long userId){

return signupService.getUser(userId);
}


@GetMapping("/getbyfname/{firstName}")
public Optional<Signup> fname(@PathVariable("firstName") String firstName) {

	return signupService.getByFirstName(firstName);
}


//Get user Data By using Lastname
	@GetMapping("/getbylname/{lastName}")
	public Optional<Signup> lname(@PathVariable("lastName") String lastName) {

		return signupService.getByLastName(lastName);
	}


//Update user details
@PutMapping("/update/{userId}")

public ResponseEntity<String>  updateSignup(@PathVariable("userId") Long userId, @RequestBody SignupDto signupDto){

return signupService.updateSignup(userId, signupDto);
}

}






// Update user details
//@PutMapping("/update/{userId}")
//public ResponseEntity<String> updateUser(@PathVariable("userId") Long userId, @RequestBody CrudDto crudDto) {
//	return crudService.updateUser(userId, crudDto);
//
//}







//@PutMapping("/update/{userId}")
//public ResponseEntity<String> updateUser(@PathVariable("userId") Long userId , @RequestBody SignupDto signupDto)
//{
//return signupService.updateUser(userId,signupDto);
//
