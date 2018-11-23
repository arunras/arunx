package com.arunx.arunx;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.arunx.model.Friend;

public class SystemTests {

	@Test
	public void testCreateReadDelete() {
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8000/friends";
		Friend friend = new Friend("Gordon", "Moore");
		ResponseEntity<Friend> entity = restTemplate.postForEntity(url, friend, Friend.class);
	
		Friend[] friends = restTemplate.getForObject(url, Friend[].class);
		Assertions.assertThat(friends).extracting(Friend::getFirstName).containsOnly("Gordon");
		
		restTemplate.delete(url + "/" + entity.getBody().getId());
		Assertions.assertThat(restTemplate.getForObject(url, Friend[].class)).isEmpty();
	}
}
