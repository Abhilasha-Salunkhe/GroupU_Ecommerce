package com.customer;

import java.util.Scanner;

public class Customer {

	
	public static void logIn() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("  Login>> ");
		System.out.println("Enter Username>>");
		String uname=sc.next();
		
		System.out.println("Enter Password>>");
		String pass=sc.next();
		
		toCheck(uname,pass);
	
	}
	
	public static void toCheck(String uname,String pass) {
	
		if(uname.equals("u") && pass.equals("p")) {
			System.out.println("Login Successfully!!");

		}else {
			System.out.println("Username OR Password is Wrong!!");
			option();
		}
		
	}
	
	
	public static void register() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Your Name>>");
		String name=sc.nextLine();
		
		System.out.println("Enter Username>>");
		String uname=sc.next();
		if(uname !="") {
			
			
		}else {
			System.out.println("Username already exist>>");
			
			register();
		}
		
		System.out.println("Enter Password>>");
		String pass=sc.next();
		
		
		
		logIn();
		
		
	}
	
	public static void option() {
		Scanner sc=new Scanner(System.in);

		System.out.println("Customer>>");

		System.out.println("Enter Your Choice>>");
		System.out.println("1:Login \n2:Register ");
		int n = sc.nextInt();

		switch (n) {

		case 1:
			logIn();
			break;
		case 2:
			register();
			break;

		default:
			System.out.println("Invalid Option");
		}
	}
	
	
	public static void main(String[] args) {
		
		option();
	}
	
	
}
