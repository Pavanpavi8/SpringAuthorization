package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.MyUser;
import com.example.demo.Model.MyUserRepo;
import com.example.demo.Service.MyUserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
	@Autowired
	MyUserService myUserService;
	
	@Autowired
	MyUserRepo userRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome() {
		return new ResponseEntity<>("Welcome to Home Page , Not Secure" , HttpStatus.OK);
	}
	
	@GetMapping("/admin/page")
	public ResponseEntity<String> adminPage() {
		return new ResponseEntity<>("Welcome to Admin Page ,  Secured" , HttpStatus.OK);
	}
	
	@GetMapping("/user/page")
	public ResponseEntity<String> userPage() {
		return new ResponseEntity<>("Welcome to User Page ,  Secured" , HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> postMethodName(@RequestBody MyUser register) {
		userRepo.save(register);
		return new ResponseEntity<>("Registration Success" , HttpStatus.CREATED);
	}
	

}
