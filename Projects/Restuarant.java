//Menuitem:-
//	iteamName String
//	itemPrice int
//	
//order:-
//	MenuItem[] items
//	itemcount
//	addItem()
//	calBill()
//	displayOrder()
//
//Main:-
//	intiizemenu()
//	displaymenu()


package com.Projects;

import java.util.Scanner;

class MenuItem{
	private String itemName;
	private int itemPrice;
	MenuItem(String name,int price){
		itemName=name;
		itemPrice=price;
	}
	int getitemPrice() {
		return this.itemPrice;
	}
	
	String getitemName() {
		return itemName;
	}
	public String toString() {
		
		return "ITEM NAME : "+itemName+"\t ITEM PRICE : "+itemPrice+"\n";
		
	}
	void updateMenuItem(String itemName,int price1){
		this.itemName=itemName;
		this.itemPrice=price1;
	}
	
}

class order{
	MenuItem menu[];
	order orderlist[];
	int menulist;
	int itemCount;
	int quantity;
	String items;
	int price;
	order(String a,int b){
		items=a;
		price=b;
		quantity=1; 
	}
	order(int size,int size1){
		menu=new MenuItem[size];
		orderlist=new order[size1];
	}
	String getitems() {
		return items; 
	}
	void addItemToMenu(String Name,int price) {
		if(menulist==menu.length) {
			System.out.println("full of items in restuarant ");
		}else {
			menu[menulist]=new MenuItem(Name,price);
			menulist++;
		}
	}
	
	void orderItem(int a) {	
		if(itemCount==orderlist.length) {
			System.out.println("order reached maximum");
		}else {
			
			orderlist[itemCount]=new order(menu[a].getitemName(),menu[a].getitemPrice());
			itemCount++;
		} 
	} 
	
	public String toString() {
		return "itemName"+"\t"+items+"itemPrice"+"\t"+price+"itemQuantity"+"\t"+quantity; 
	}
	
	void displayOrders() {
		for(int i=0;i<itemCount;i++) {
			System.out.println(orderlist[i]);
		}
		
	}
	void displayMenu() {
		for(int i=0;i<menulist;i++) {
			System.out.println(i+" "+menu[i]);
		}
	}
	
	void calculateTotal() {
		double sum=0,total;
		for(int i=0;i<itemCount;i++) {
			sum+=orderlist[i].price;
		}
		total=sum;
		if(sum>=1000) {
			double discount=sum*10/100;
			total-=discount; 
			System.out.println("Welcome to Mefil");
			System.out.println("total amount :"+sum);
			System.out.println("discount amout :"+discount);
			System.out.println("amount to pay :"+total);
			System.out.println("Thank you for visiting");
			System.out.println("come again");
		}else {
			System.out.println("Welcome to Mefil");
			System.out.println("total amount :"+sum);
			System.out.println("amount to pay :"+total);
			System.out.println("Thank you for visiting");
			System.out.println("come again");

		}
	}
	
	void itemQuantity(int quantity,int index){
		if(index<itemCount) {
		orderlist[index].updateOrder(quantity); 
		}
	}
	void updateOrder(int quantity) {
		this.quantity=quantity;
		this.price*=quantity; 
	}
	
	void removeItemFromMenu(int itemindex) {
		if(itemindex<=menulist) {
			menu[itemindex].updateMenuItem(" ",0);;
		}
	}
	void updateItemInMenu(int index,Scanner sc) {
		if(index<menu.length) {
			sc.nextLine();
			System.out.print("Enter itemname: ");
			String itemName=sc.next();
			System.out.print("Enter itemPrice: ");
			int price1=sc.nextInt();
			menu[index].updateMenuItem(itemName,price1);
		}
	}
}

public class Restuarant {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		order o1=new order(20,6);
		boolean exit=false;
		while(!exit) {
			System.out.println("1. to add item to Menu");
			System.out.println("2. display Menu ");
			System.out.println("3. remove item");
			System.out.println("4. update menu");
			System.out.println("5. to exit");
			System.out.println("select operater :");
			int op=sc.nextInt();
			switch(op) {
				case 1:
					sc.nextLine();
					System.out.print("Enter item name: ");
					String itemname=sc.nextLine();
					System.out.print("Enter item Price: "); 
					int price=sc.nextInt();
					o1.addItemToMenu(itemname, price);
					break;

				case 2:
					o1.displayMenu(); 
					break; 
				
				case 3:
					System.out.print("Enter item index to remove: ");
					int itemindex=sc.nextInt();
					o1.removeItemFromMenu(itemindex);
					break;
					
				case 4:
					System.out.print("Enter item index to update: ");
					int itemindex1=sc.nextInt();
					o1.updateItemInMenu(itemindex1, sc);
					break; 
					
				case 5:
					exit=true;
					break;

			}
		}
			
			
			boolean exit1=false;
			while(!exit1) {
				System.out.println("1.Display Menu");
				System.out.println("2.Order Item");
				System.out.println("3.Display Ordered Items");
				System.out.println("4.increase quantity by value");
				System.out.println("5.Pay Bill");
				System.out.println("6.Exit");
				System.out.println("Enter Option:");
				int op1=sc.nextInt();
				switch(op1) {
					case 1: 
						o1.displayMenu();
						break;

					case 2:
						sc.nextLine();
						System.out.print("Enter itemNumber: ");
						int itemindex=sc.nextInt();
						o1.orderItem(itemindex);
						break;

					case 3:
						o1.displayOrders();
						break;
						
					case 4:
						System.out.print("Enter item Quantity: ");
						int quantity=sc.nextInt();
						System.out.print("Enter item index: ");
						int index=sc.nextInt();
						o1.itemQuantity(quantity,index);

					case 5:
						o1.calculateTotal();
						break;

					case 6:
						exit1=true;
						break;

				}
			
			
			}

		sc.close();
	}
}
