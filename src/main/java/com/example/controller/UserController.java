package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/api/add/user")
	public ResponseEntity addUser(@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("salt") String salt,
			@RequestParam("nickname") String nickname,
			@RequestParam("repname") String repname,
			@RequestParam("coname") String coname,
			@RequestParam("img") String img,
			@RequestParam("longitude") Float logitude,
			@RequestParam("latitude") Float latitude,
			@RequestParam("location") String location,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		User user = User.builder()
			.email(email)
			.password(password)
			.salt(salt)
			.nickname(nickname)
			.repname(repname)
			.coname(coname)
			.img(img)
			.longitude(logitude)
			.latitude(latitude)
			.location(location)
			.phoneNumber(phoneNumber)
			.build();
		
		User result = userService.save(user);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/api/get/user1")
	public Page<User> getUser1(@RequestParam("page")Integer page,
				@RequestParam("size")Integer size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		
		return userService.findAll(pageRequest);
	}
	
}
