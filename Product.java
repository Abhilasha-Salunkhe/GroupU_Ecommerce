package com.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.customer.ConnectDb;

public class Product {

	
	public static void buyProduct() {
		
	}
	
	public static void cart(ArrayList<Integer> proList) {
		Connection con=ConnectDb.getConnection();
		try {
			PreparedStatement pst=con.prepareStatement("select * from productlist");
			ResultSet rs=pst.executeQuery();
			System.out.println("Your Cart List>>\n");
			while(rs.next()) {
				
				for(Integer p:proList) {
					if(p==rs.getInt(1)) {
						System.out.println("Product Id>> "+rs.getInt(1)+" Product Name>> "+rs.getString(2)+" Price>> "+rs.getInt(4)+" Quantity>> 1");
					}
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void productList() {
		Connection connection=ConnectDb.getConnection();
		
		try {
			String sql="select * from productlist order by Price asc";
			PreparedStatement pst=connection.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			System.out.println("ProductId "+ " Product Name "+ " Details"+ " Price"+" Quantity");
			while(rs.next()) {
				System.out.println("ProductId "+rs.getInt(1)+" Product Name "+rs.getString(2)+" Details"+rs.getString(3)+" Price "+rs.getInt(4)+" Quantity"+rs.getInt(5));
			}
			
			pst.close();
			rs.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
}
