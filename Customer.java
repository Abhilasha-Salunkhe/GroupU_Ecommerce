package com.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.main.FlowControll;
import com.product.Product;

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
	
	public static void toCheck(String uname,String pass)  {
		
		Connection connection = ConnectDb.getConnection();
		Scanner sc=new Scanner(System.in);
		
		try {

			String sql = "select * from userlogin";
			PreparedStatement pst = connection.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			boolean flag=false;
			while (rs.next()) {
				if (uname.equals(rs.getString(3)) && pass.equals(rs.getString(4))) {
				//	System.out.println("Login Successfully!!");
					flag=true;
					

				} 
			}
			
			if(flag) {
				System.out.println("Login Successfully!!");
				System.out.println("1.See all products");
				System.out.println("2.purchase");
				int choice=sc.nextInt();
				if(choice==1) {
					FlowControll.productOp();
				}
				else if(choice==2)
				{
					FlowControll.productOp();
					System.out.println("Select Product From Above List>>");
					
				//	ArrayList<Integer> cartList=new ArrayList<Integer>();
					
					ArrayList<Integer> proList=new ArrayList<Integer>();
					
					System.out.println("Enter Product id");
					//int pid=sc.nextInt();
					//proList.add(pid);
					
					proList.add(sc.nextInt());
					
					System.out.println("Do you want to purchase More Product(y/n)");
					String s=sc.next();
					while(s.equals("y")) {
					 	System.out.println("Enter Product id");
						proList.add(sc.nextInt());
					
					System.out.println("Do you want to purchase More Product(y/n)");
					 s=sc.next();
					}
					
					
				//	System.out.println(proList);
					
					int i=0;
					int totalprice=0;
					Connection con=ConnectDb.getConnection();
					PreparedStatement stmt=con.prepareStatement("select prod_Id,price from productlist");
					ResultSet rs1=stmt.executeQuery();
					while(rs1.next())
					{
						int id=rs1.getInt(1);
						int price=rs1.getInt(2);
						for(Integer p:proList)
						{
						 if(p==id)
						 {
							 totalprice=totalprice+price;
							 
						 }
						}
						  
					}
					
					
					
					
					rs1.close();
					Product.cart(proList);
					System.out.println("Total Price Of All Product>> "+totalprice);
					
					System.out.println("1:Confirm \n2:Exit");
					int op=sc.nextInt();
					if(op==1) {

						PreparedStatement pst2=con.prepareStatement("insert into purchase(userName,prodId) values(?,?)");
						pst2.setString(1, uname);
						String pId="";
						//String qnty="";
						for(Integer p:proList)
						{
							pId=pId+p+"," ;
			
							PreparedStatement pst1=con.prepareStatement("update productlist set quantity=quantity-1 where prod_id="+p);
							pst1.execute();
							
						}
						pst2.setString(2, pId);
						//pst2.setInt(3,1);
						pst2.execute();
						//System.out.println("Record inserted");
							
						System.out.println("         Thank You");
						System.out.println("Your purchase was successfull!! ");
						
					}else if(op==2) {
						
					}
					
					
				
					
				}
				
			}else {
				System.out.println("Username OR Password is Wrong!!");
				customerLogin();
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public static void register()  {
		
		Connection connection = ConnectDb.getConnection();
		try {
		String sql = "select * from userlogin";
		PreparedStatement pst = connection.prepareStatement(sql);
		
		ResultSet rs = pst.executeQuery();

		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Your first Name>>");
		String fname=sc.nextLine();
		System.out.println("Enter Your last Name>>");
		String lname=sc.nextLine();
		
		System.out.println("Enter Username>>");
		String uname=sc.next();
		boolean flag=true;
		
			while(rs.next())
			{
			
			if(uname !=rs.getString(3)) {
				
				flag=false;
			}
			}
	
		
		if(!flag) {
			System.out.println("Enter Password>>");
			String pass=sc.next();
			
			String sqlQuery="insert into userlogin (first_Name,last_Name,user_Name,user_Password) values (?,?,?,?)";
			PreparedStatement pst1 = connection.prepareStatement(sqlQuery);
			pst1.setString(1,fname);
			pst1.setString(2,lname);
			pst1.setString(3,uname);
			pst1.setString(4,pass);
			pst1.executeUpdate();
			
			System.out.println("Registration Successfull!!");
			
		}else {
			System.out.println("Username already exist>>");
			
			register();
		}
		
		
		
		
		logIn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void customerLogin() {
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
	
	
}
