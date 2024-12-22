package com.Projects;
import java.util.Scanner;
public class ArrayOperations{
	static int a[];
//	static int size=a.length;
	static int currentsize=0;
	static void insert(Scanner sc) {
		System.out.print("Enter Position : ");
		int possition=sc.nextInt();
		if(possition<a.length && currentsize<a.length) {
			if(a[possition]==0) {
			System.out.print("Enter Value : ");
			int value=sc.nextInt();
			a[possition]=value;
			currentsize++;
			System.out.println(value+" inserted");
			}
		}else {
			System.out.println("Out of index");
		}
	}
	static void insert1(Scanner sc) {
		System.out.print("Enter no of elements : ");
		int count=sc.nextInt();
		
		for(int j=0;j<a.length;j++) {
			for(int i=0;i<a.length-1;i++) {
				if(a[i]>a[i+1]) {
					int t=a[i];
					a[i]=a[i+1];
					a[i+1]=t;
				}
			}
		}
		
		if((count+currentsize)<=a.length) {
			for(int i=0;i<count;i++) {
				System.out.print("Enter Value : ");
				int value=sc.nextInt();
				a[i]=value;
				currentsize++;
				System.out.println(value+" Inserted");
			}
		}else {
			System.out.println("Out of index");
		}
	}
	static void search(Scanner sc) {
		System.out.println("Enter Element to Search : ");
		int ele=sc.nextInt();
		boolean b=true;
		for(int i=0;i<a.length;i++) {
			if(a[i]==ele) {
				System.out.println(ele+" found at possition "+i);
				b=false;
				break;
			}
		}
		if(b)
			System.out.println("Not found"); 
		
	}
	static void update(Scanner sc) {
		System.out.println("Enter Position : ");
		int possition=sc.nextInt();
		if(possition<a.length) {
			System.out.print("Enter Value : ");
			int value=sc.nextInt();
			if (a[possition]==0) {
				currentsize++;
			}
			a[possition]=value;
			System.out.println(value+" updated");
		}
	}
	static void delete(Scanner sc) {
		int len=a.length;
		System.out.println("Enter Position : ");
		int possition=sc.nextInt();
		if(possition<a.length) {
			for(int i=possition;i<a.length-1;i++) {
				a[i]=a[i+1];
			}
			len--;
			a[len]=0;
			currentsize--;
			System.out.println("Deleted sucessfully");
		}
	}
	static void displayall() {
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
	static void no_of_ele() {
		System.out.println("no of elements in array are : "+currentsize);
	}
	static void delete_ele(Scanner sc) {
		int len=a.length;
		System.out.println("Enter Element : ");
		int ele=sc.nextInt();
		boolean b=true;
			for(int i=0;i<a.length;i++) {
				if(a[i]==ele) {
					b=false;
					for(int j=i;j<a.length-1;j++) {
						a[j]=a[j+1];
					}
				}
			}
			if(b) {
				System.out.println("no such element");
				return;
			}
			len--;
			a[len]=0;
			currentsize--;
			System.out.println(ele+" Deleted");
		}
	static void display_ele(Scanner sc) {
		for(int j=0;j<a.length;j++) {
		for(int i=0;i<a.length-1;i++) {
			if(a[i]>a[i+1]) {
				int t=a[i];
				a[i]=a[i+1];
				a[i+1]=t;
			}
		}
		}
		for(int i=(a.length-currentsize);i<a.length;i++) {
			System.out.println(a[i]); 
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of the Array : ");
		int value=sc.nextInt();
		a=new int[value];
		boolean exit=false;
		while(!exit) {
			System.out.println("1.Insert Element : ");
			System.out.println("2.Insert Elements : ");
			System.out.println("3.Search for Element : ");
			System.out.println("4.Delete an Element at possition : ");
			System.out.println("5.Display all Elements : ");
			System.out.println("6.Display number of Elements : ");
			System.out.println("7.Update Element at possition : ");
			System.out.println("8.Delete Element : ");
			System.out.println("9.Display Elements : ");
			System.out.println("10.Exit : ");
			System.out.print("Select a option : ");
			int op=sc.nextInt();
			
			switch(op) {
			case 1:
				insert(sc);
				break;
			case 2:
				insert1(sc);
				break;
			case 3:
				search(sc);
				break;
			case 4:
				delete(sc);
				break;
			case 5:
				displayall();
				break;
			case 6:
				no_of_ele();
				break;
			case 7:
				update(sc);
				break;
			case 8:
				delete_ele(sc);
				break;
			case 9:
				display_ele(sc);
				break;
			case 10:
				exit=true;
				System.out.println("Completed Array Operations");
				break;
			default:
				System.out.println("Invalid Option");
			}
		}
		sc.close();
		
	}

}
