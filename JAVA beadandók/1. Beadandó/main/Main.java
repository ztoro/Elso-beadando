package main;

import financial.bank.Bank;
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
}
