package com.Projects;
import java.util.Scanner; 
public class AtmOperations {

	
	double Balance_Amount;
	String Password="Codegnan@143";
	String Name_of_AccountHolder="Siddartha Royal";
	int Pin=2002;
	final double Account_Number = 4046;
	
	boolean checkPassword(String Password) {
		
		if(this.Password.equals(Password)) {
			return true;
		}else {
			return false;
		}
	} 
	
	double checkBalance() {
		return Balance_Amount; 
	}
	
	boolean withdrawAmount(Scanner sc) { 
		System.out.print("\nEnter amount to withdraw : "); 
		double amount=sc.nextDouble();
		if(Balance_Amount>=amount) {
			Balance_Amount-=amount;
			return true;
		}
		return false;
	}
	
	boolean depositAmount(Scanner sc) {
		System.out.print("\nEnter amount to deposit : ");
		double amount=sc.nextDouble();
		if(amount>0) {
			Balance_Amount+=amount;
			return true;
		}else {
		return false;
		}
	}
	
	boolean accountDetails(Scanner sc) {
		System.out.print("\nEnter Security Pin : ");
		int pin=sc.nextInt();
		if(this.Pin==pin) {
			System.out.println("\nName of AccountHolder : "+Name_of_AccountHolder);
			System.out.println("Account Number : "+Account_Number);
			System.out.println("Balance Amount : "+Balance_Amount);
			return true;
		}else {
			return false;
		}
	}
	
	boolean exit() {
		return true;
	}
	
	
	public static void main(String[] args) {
		
		AtmOperations obj=new AtmOperations();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter your Password : ");
		String pass=sc.nextLine();
		if(!(obj.checkPassword(pass))) {
			System.out.println("Invalid Password...");
			sc.close();
			return;
		}
		boolean exit=false;
		while(!(exit)) {
			System.out.println("1.Check Account Balance.");
			System.out.println("2.Deposit Amount.");
			System.out.println("3.Withdraw Amount.");
			System.out.println("4.exit.");
			System.out.println("5.Account Details.");
			System.out.print("\nSelect Any Option of your Desire : ");
			int op=sc.nextInt();
			switch(op) {
			case 1:
				System.out.println("\nYour Current Balance = "+obj.checkBalance()+"\n");
				break;
			case 2:
				if(obj.depositAmount(sc)) { 
					System.out.println("\nAmount Deposited Succesfully...\n");
				}else {
					System.out.println("\nEntered Invalid Amount\n");
				}
				break;
			case 3:
				if(obj.withdrawAmount(sc)) {
					System.out.println("\nAmount Withdrawed Succesfully...\n");
				}else {
					System.out.println("\nInsufficient Balance...\n");
				}
				break;
			case 4:
				exit=obj.exit();
				System.out.println("\nThank You For Using our Services...");
				break;
			case 5:
				if(obj.accountDetails(sc)) {
					System.out.println("\nDetails Fetched Succesfully...\n");
				}else {
					System.out.println("\nInvalid Pin Number...\n");
				}
				break;
				
			}
		}
		
		sc.close();
		
	}

}
