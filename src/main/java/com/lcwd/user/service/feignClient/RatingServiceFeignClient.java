package com.lcwd.user.service.feignClient;

import java.util.ArrayList;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcwd.user.service.entities.Rating;

@FeignClient(name = "Rating-Service")
public interface RatingServiceFeignClient{
	
	@GetMapping("/ratings/users/{ratingId}")
	ArrayList<Rating> getRating(@PathVariable String ratingId);	

}
