package com.lcwd.user.service.entities;

public class Rating {
	
	private String ratingUd;
	private String userId;
	private String hotelId;
	private String rating;
	private String feedback;
	
	public String getRatingUd() {
		return ratingUd;
	}
	public void setRatingUd(String ratingUd) {
		this.ratingUd = ratingUd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
	

}
