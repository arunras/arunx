package com.arunx.arunx;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.arunx.controller.FriendController;
import com.arunx.model.Friend;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {

	@Autowired
	private FriendController friendController;
	
	@Test
	public void testCreateReadDelete() {
		Friend friend = new Friend("Gordon", "Moore");
		Friend friendResult = friendController.create(friend);
		
		Iterable<Friend> friends = friendController.read();
		Assertions.assertThat(friends).first().hasFieldOrPropertyWithValue("firstName", "Gordon");
		
		friendController.delete(friendResult.getId());
		//Assertions.assertThat(friendController.read()).isEmpty();
	}
}
