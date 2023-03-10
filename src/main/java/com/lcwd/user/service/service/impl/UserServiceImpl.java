package com.lcwd.user.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.feignClient.RatingServiceFeignClient;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private RatingServiceFeignClient ratingFeignClient;
	

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		user.setUserId(UUID.randomUUID().toString()); // generation of unique Id 
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		User user =  userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given Id is not found on srever :"+userId));
//	ArrayList<Rating> forObject = restTemplate.getForObject("http://Rating-Service/ratings/users/"+user.getUserId(), ArrayList.class);
			ArrayList<Rating> forObject = ratingFeignClient.getRating(userId);
		
		
		System.out.println(forObject);
	

	user.setRatings(forObject);
	return user;
	}
	
}
