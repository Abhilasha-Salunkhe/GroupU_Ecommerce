
import java.util.Scanner;

public class AdminLogin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	String AdminId = "GroupU";
		String Password = "GroupU@123";
		
		System.out.println("Log in");
	System.out.println("Enter Admin Id : ");
		 AdminId = sc.next();
		 
		 System.out.println("Password : ");
			Password = sc.next();
			
			if(AdminId.equals(AdminId) && Password.equals(Password)) {
				System.out.println("Logged in Successfully");
			}
	}

	
	}


