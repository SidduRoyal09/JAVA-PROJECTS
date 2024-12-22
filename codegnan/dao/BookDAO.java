package com.codegnan.dao;

import java.util.TreeSet;

import com.codegnan.model.Book;
import com.codegnan.model.PopularityComparator;

public class BookDAO {
	private TreeSet<Book> books;
	
	public BookDAO() {
		books=new TreeSet<>(new PopularityComparator());
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void updateBookRating(int isbn,Book book) {
		Book book1=getBookById(isbn);
		if(book1!=null) {
			books.remove(book1);
			books.add(book);
		} 
		
	}
	public Book getBookById(int id) {
		for(Book book:books) {
			if(book.getISBN()==id)return book;
		}
		return null; 
	}
	public TreeSet<Book>getAllBooks() {
		return books;
	} 

}
