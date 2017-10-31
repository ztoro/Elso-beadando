package financial.person;

import financial.bank.Bank;
import main.Main;

public class Customer {
	
 	private String name;
	private int birthYear;
	private Bank bank;
	private int amount;
	
	private Customer(String name, int birthYear, Bank bankName) {
		this.name = name;
		this.birthYear = birthYear;
		this.bank = bankName;
		this.amount = 0;
	}
	
	public Customer makeCustomer(String name, int birthYear, String bankName) {
		
		Bank bank;
		if (Main.failBirthYear(birthYear) || Main.failBankName(bankName) || Main.failName(name)) {
			return null;
		}
		
		bank = Bank.valueOf(bankName);
		Customer newCustomer = new Customer(name,birthYear,bank);
		return newCustomer;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void decreaseAmount(int value) {
		amount = amount - value;
	}
	
	public void increaseAmount(int value) {
		amount = amount + value;
	}
	
	public String toString() {
		String string;
		string = getName() + ": " + Integer.toString(getAmount());
		return string;
	}
	
}
