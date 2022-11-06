package com.main;

import java.util.Scanner;

import com.customer.Customer;
import com.product.Product;
import com.admin.*;


public class FlowControll {
	
	
	
	public static void productOp() {
		System.out.println("Product List>>");
		Product.productList();
		
		
		
	}

	  public static void userLogin() {
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter  \n1:Admin \n2:Customer");
		  int n=sc.nextInt();
			  
			  switch(n) {
			  case 1:
				  AdminLogin.adminLogin();
				  break;
			  case 2:
				  Customer.customerLogin();
				  break;
			  default :
				  System.out.println("Invalid Options>>");
			  
		  }
		  
	  }
	  

	  

	
}
