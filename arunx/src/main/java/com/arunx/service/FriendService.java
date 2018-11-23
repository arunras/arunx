package com.arunx.service;

import org.springframework.data.repository.CrudRepository;

import com.arunx.model.Friend;

public interface FriendService extends CrudRepository<Friend, Integer> {
	
	public Iterable<Friend> findByFirstNameAndLastName(String firstName, String lastName);
	public Iterable<Friend> findByFirstName(String firstName);
	public Iterable<Friend> findByLastName(String lastName);
	
}
