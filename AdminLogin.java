package com.admin;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.customer.ConnectDb;

public class AdminLogin {public static void productQuantity() {
	Connection con=ConnectDb.getConnection();
	Scanner sc=new Scanner(System.in);
	try {
		PreparedStatement pst=con.prepareStatement("select * from productlist");
		ResultSet rs=pst.executeQuery();
		System.out.println("enter product id to check>>");
		int id=sc.nextInt();
		
		while(rs.next()) {
			if(id==rs.getInt(1)) {
				System.out.println("Product Quantity is>> "+rs.getInt(5));
				
			}
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	
}

public static void userList() {
	Connection con=ConnectDb.getConnection();
	try {
		PreparedStatement pst=con.prepareStatement("select * from userlogin");
		ResultSet rs=pst.executeQuery();
		System.out.println("       User List!! \n");
		
		System.out.println("FirstName"+" LastName"+" UserName");
		while(rs.next()) {
			System.out.println(rs.getString(1)+"   " +rs.getString(2)+"    " +rs.getString(3));
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public static void userHistory() {
	Connection con=ConnectDb.getConnection();
	 Scanner sc = new Scanner(System.in);

	PreparedStatement pst;
	try {
		pst = con.prepareStatement("select * from purchase");
		ResultSet rs=pst.executeQuery();
		
		System.out.println("enter username to check history>>");
		String uname=sc.next();
		System.out.println("User History>>");
		while(rs.next()) {
			if(uname.equals(rs.getString(1))){
				System.out.println();
				System.out.println("UserName>>"+rs.getString(1)+" Product Id>>"+rs.getString(2));
				
			}
			
		}
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	
}
public static void adminLogin() {
	 Scanner sc = new Scanner(System.in);
	String adminId = "";
	String pass = "";

	System.out.println("Admin Login");
	System.out.println("Enter Admin Id : ");
	adminId = sc.next();

	System.out.println("Password : ");
	pass = sc.next();

	Connection con=ConnectDb.getConnection();
	boolean flag=false;
	try {
		PreparedStatement pst=con.prepareStatement("select * from useradmin");
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			if (adminId.equals(rs.getString(1)) && pass.equals(rs.getString(2))) {
				
				flag=true;
			}

		}
		
		con.close();
		rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if (flag) {
		System.out.println("Login successfull!!");
		int loop = 1;
		while (loop == 1) {
			System.out.println("\nEnter your choice");
			System.out.println("1:To check product quantity \n2:To view users list \n3:History of user \n0:Exit");
			int choice = sc.nextInt();

			if (choice == 1) {
				productQuantity();

			} else if (choice == 2) {
				userList();

			} else if (choice == 3) {
				userHistory();

			} else if (choice == 0) {
				loop = 0;
			} else {
				System.out.println("Invalid option!!");
			}
		}

	}
	
	
	
}



}
