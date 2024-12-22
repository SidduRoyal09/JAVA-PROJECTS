package com.codegnan.service;

import java.util.TreeSet;

import com.codegnan.dao.BookDAO;
import com.codegnan.model.Book;

public class LibraryService {
	private static BookDAO bookDAO;
	public LibraryService() {
		bookDAO=new BookDAO();
	}
	public void addBook(int id,String title,String author,double rating) {
		Book book =new Book(id,title,author,rating);
		bookDAO.addBook(book);
	}
	public void updateBookRating(int id,String title,String author,double rating) {
		Book updatedBook=new Book(id,title,author,rating);
		bookDAO.updateBookRating(id,updatedBook);
	}
	
	public void getTopRatedBook() {
		
	}
	public static TreeSet<Book> getAllBooks(){
		return bookDAO.getAllBooks();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
