package com.sm;

public class Review {
	private String name;
	private int rating;
	private boolean approved;

	public Review(String name, int rating, boolean approved) {
		this.name = name;
		this.rating = rating;
		this.approved = approved;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@Override
	public String toString() {
		return "Review [name=" + name + ", rating=" + rating + ", approved=" + approved + "]";
	}

}
