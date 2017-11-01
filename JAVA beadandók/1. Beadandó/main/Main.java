package main;

import financial.bank.Bank;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.isLowerCase;
import java.io.IOException;

import financial.Simulator;

public class Main {
	
	public static void main(String[] args) throws IOException {
		if(args.length != 3) {
	            System.out.println("Not enough arguments!");
	    }
	        
	    String bankName = args[0];
	    String inputFile = args[1];
	    String outputFile = args[2];
	        
	    Simulator simulator = new Simulator(bankName,1000000,outputFile);
	    simulator.simulate(inputFile);
	    simulator.close();

	}
	
	
	public static boolean failBankName(String bankName) {
		try {
			Bank bankValue = Bank.valueOf(bankName);
			return false;
		} catch (IllegalArgumentException e) {
			return true;
		}
	}
	
	public static boolean failBirthYear(int birthYear) {
		if (birthYear < 1918 || birthYear > 1998) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean failName(String name) {
		
		String[] splitName = name.split(" ");
		if(splitName.length<2) {
			return true;
		}
		
		if(splitName.length>4) {
			return true;
		}
		
		for(int i=0;i<splitName.length;i++) {
			if(splitName[i].length()<3){
				return true;
			}
			
			if(isLowerCase(splitName[i].charAt(0))) {
				return true;
			}
			
			if(!splitName[i].matches("\\w+")) {
				return true;
			}
			
			for(int j=1;j<splitName[i].length();j++) {
				if(isUpperCase(splitName[i].charAt(j))) {
					return true;
				}
			}
		}
		
		return false;
		
	}
}
