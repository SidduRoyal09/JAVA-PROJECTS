package com.codegnan.view;

import java.util.Scanner;

import com.codegnan.model.Book;
import com.codegnan.service.*;

public class BookView {
	private LibraryService bookService;
	BookView(){
		bookService=new LibraryService();
	}
	private void add(Scanner sc) {
		System.out.print("Enter ID: ");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Title: ");
		String title=sc.nextLine();
		System.out.print("Enter Author: ");
		String author=sc.nextLine(); 
		System.out.print("Enter Rating: ");
		double rating=sc.nextDouble();
		bookService.addBook(id,title,author,rating);
		System.out.println("Book Added Sucessfully");
	}
	private void update(Scanner sc) {
		System.out.print("Enter ID: ");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.print("Enter New Title: ");
		String title=sc.nextLine();
		System.out.print("Enter New Author: ");
		String author=sc.nextLine();
		System.out.print("Enter New Rating");
		double rating=sc.nextDouble();
		bookService.updateBookRating(id,title,author,rating);
		System.out.print("Book updated successfully ");

	}
	private void getAll() {
		System.out.println("\nBooks:\n");
		for(Book book:LibraryService.getAllBooks()) {
			System.out.println(book);
		}
	}
	private void getAllTopRated() {
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean exit=false;
		BookView bv=new BookView();
		while(!exit) {
			System.out.println("1. add a book");
			System.out.println("2. update rating");
			System.out.println("3. view all Books");
			System.out.println("4. view Top-Rated Book");
			System.out.println("5. Exit");
			
			System.out.print("Select Operation: ");
			int op=sc.nextInt();
			switch(op){
				case 1:
					bv.add(sc);
					break;
				case 2:
					bv.update(sc);
					break;
				case 3:
					bv.getAll();
					break;
				case 4:
					bv.getAllTopRated();
					break;
				case 5:
					exit=true;
					System.out.println("\n"+"***** THANKS VISIT AGAIN *****");
					break; 
				default:
					System.out.println("NOT VALID OPTION");
			}
		}
		sc.close();
		
	}

}

