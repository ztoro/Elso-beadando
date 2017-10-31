package financial;

import financial.bank.*;
import financial.person.*;
import java.util.*;
import java.io.*;


public class Simulator {
	
	private ATM atm;
	private ArrayList<Customer> customers; 
	private PrintWriter pwLog; 
	
	public Simulator(String bankName,int initAmount,String outputFileName) throws IOException{
		try{
			atm = ATM.makeATM(bankName, initAmount);
			pwLog=new PrintWriter (outputFileName);
			customers= new ArrayList<Customer>();
		}
		catch(IllegalArgumentException e){
		}
	}
}
