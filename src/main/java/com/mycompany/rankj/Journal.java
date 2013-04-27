package com.mycompany.rankj;

/*
 * This bean represents a basic journal object
 * 
 */
public class Journal {
	
	private String name;
	private Double score;
	
	public Journal(final String name, final Double score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public Double getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return "[" + this.name + " " + this.score + "]";
	}
	
}
