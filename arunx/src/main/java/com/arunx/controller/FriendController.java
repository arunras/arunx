package com.arunx.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arunx.model.Friend;
import com.arunx.service.FriendService;

@RestController
public class FriendController {
	@Autowired
	private FriendService friendService;
	
	@GetMapping("/friends")
	public Iterable<Friend> read() {
		return friendService.findAll();
	}
	
	@PostMapping("/friends")
	public Friend create(@Valid @RequestBody Friend friend) {
			return friendService.save(friend);
	}
	
	
	/* Local Handling
	@PostMapping("/friends")
	public Friend create(@RequestBody Friend friend) {
		if (friend.getId() == 0 && friend.getFirstName() != null && friend.getLastName() != null) {
			return friendService.save(friend);
		} else {
			throw new ValidationException("friend cannot be created");
		}
	}
	*/

	/*
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public ErrorMessage exceptionHandler(ValidationException e) {
		return new ErrorMessage("400", e.getMessage());
	}
	 
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<String> exceptionHandler(ValidationException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	*/
	
	@PutMapping("/friends")
	//public Friend update(@RequestBody Friend friend) {
	//Local Exception Handler
	public ResponseEntity<Friend> update(@RequestBody Friend friend) {
		if(friendService.findById(friend.getId()).isPresent()) {
			return new ResponseEntity<>(friendService.save(friend), HttpStatus.OK);
		} else {
			return new ResponseEntity<Friend>(friend, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/friends/{id}")
	public void delete(@PathVariable Integer id) {
		friendService.deleteById(id);
	}
	
	@GetMapping("/friends/{id}")
	public Optional<Friend> findById(@PathVariable Integer id) {
		return friendService.findById(id);
	}
	
	@GetMapping("/friends/search")
	public Iterable<Friend> findByQuery(@RequestParam(value="first", required=false) String firstName, @RequestParam(value="last", required=false) String lastName) {
		if (firstName != null && lastName != null) {
			return friendService.findByFirstNameAndLastName(firstName, lastName);
		} else if (firstName != null) {
			return friendService.findByFirstName(firstName);
		} else if (lastName != null) {
			return friendService.findByLastName(lastName);
		} else {
			return friendService.findAll();
		}
	}
}
