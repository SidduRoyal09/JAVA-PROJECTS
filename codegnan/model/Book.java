package com.codegnan.model;

public class Book {
	private String title;
	private String author;
	private int ISBN;
	private double rating;
	
	

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public int getISBN() {
		return ISBN;
	}



	public void setISBN(int iSBN) {
		ISBN =iSBN;
	}


	public double getRating() {
		return rating;
	}



	public void setRating(double rating) {
		this.rating = rating;
	}


	public String toString() {
		return "Book "+"\n"+" title=" + title + "\n"+" author=" + author + "\n"+ " ISBN=" + ISBN + "\n"+ " rating=" + rating + "\n";
	}

	
	
	public Book(int iSBN,String title, String author, double rating) {
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.rating = rating;
	}

}
