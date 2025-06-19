package com.abc;
import java.util.*;
public class BankCustomer {
	private String id,firstName,lastName;
	private double balance;
	
	public BankCustomer(String id, String firstName, String lastName, double balance) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		
	}
	
	public String getId() { return(id);}
	public String getFirstName() {return(firstName);}
	public String getLastName() {return(lastName);}
	public double getBalance() {return(balance);}
	public double getBalanceNoSign() {return(Math.abs(balance));}
	public double setBalance(double balance) {return(this.balance=balance);}
	
	private static HashMap customers;
	static {
		customers = new HashMap();
		customers.put("id001",new BankCustomer("id001", "Esha" , "Hacker", 3456.78));
		customers.put("id002",new BankCustomer("id002", "Rahul" , "Hacker", -3456.78));
		customers.put("id003",new BankCustomer("id003", "Lekha" , "Hacker", 987654.78));
		
	}
	
	public static BankCustomer getCustomer(String id) {
		
		return(BankCustomer)customers.get(id);
	}
	

}
