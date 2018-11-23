package com.arunx.arunx.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.arunx.model.Friend;
import com.arunx.service.FriendService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class testCreateReadDelete {
	
	@Autowired
	private FriendService friendService;
	
	@Test
	public void testCreatReadDelete() {
		friendService.deleteAll();
		Assertions.assertThat(friendService.findAll()).isEmpty();
		
		Friend friend = new Friend("Gordon", "Moore");
		friendService.save(friend);
		
		Iterable<Friend> friends = friendService.findAll();
		Assertions.assertThat(friends).extracting(Friend::getFirstName).containsOnly("Gordon");
		
		friendService.deleteAll();
		Assertions.assertThat(friendService.findAll()).isEmpty();
	}

}
