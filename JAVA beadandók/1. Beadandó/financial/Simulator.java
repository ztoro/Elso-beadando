package financial;

import financial.bank.*;
import financial.person.*;
import java.util.*;
import java.io.*;


public class Simulator {
	
	private ATM atm;
	private ArrayList<Customer> customers; 
	private PrintWriter pwLog; 
	
	public Simulator(String bankName,int initAmount,String outputFileName) throws IOException {
		try {
			atm = ATM.makeATM(bankName, initAmount);
			pwLog=new PrintWriter (outputFileName);
			customers= new ArrayList<Customer>();
		}
		catch(IllegalArgumentException e) {
		}
	}
	
	private Customer getCustomerByName(String name) {
		for(int i=0; i<customers.size(); i++) {
			if(name.equals(customers.get(i).getName())) {
				return customers.get(i);
			}
		}
		return null;
	}
	
    public void insertCustomer(String customerName, int birthYear, String bankName) {
        if (getCustomerByName(customerName) == null) {
            Customer customer = Customer.makeCustomer(customerName, birthYear, bankName);
            if (customer != null) {
                customers.add(customer);
            }
        }
    }
	
	public void withdrawCash(String customerName, int amount) {
		Customer customer = getCustomerByName(customerName);
		if (atm.getAmount() >= amount && amount > 0 && customer != null) {
			int fee;
			fee = atm.calculateFee(customer.getBank(), amount);
			if (customer.getAmount() >= fee+amount) {
					customer.decreaseAmount(fee+amount);
		            atm.decreaseAmount(amount);
		            pwLog.println(customer);
			}
		}
	}
    
    public void depositCash(String customerName, int amount) {
    	Customer customer = getCustomerByName(customerName);
        if (amount > 0 && customer != null) {
            customer.increaseAmount(amount);
            atm.increaseAmount(amount);
            pwLog.println(customer);
        }
    }
    
    
    public void simulate(String inputFileName) throws IOException {
    	
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        String[] input;
        String line;
        String mainOperation;
        String parameter;
        
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            input = line.split(":");
            if (input.length == 2) {
                mainOperation = input[0];
                parameter = input[1];
                
                switch (mainOperation) {
                	case "REG":
                		String[] valuesReg = parameter.split(",");
                		if (valuesReg.length == 3 && valuesReg[1].matches("[0-9]+")) {
                			insertCustomer(valuesReg[0], Integer.parseInt(valuesReg[1]),valuesReg[2]);
                		}
                		break;
                		
                	case "GET":
                		String[] valuesGet = parameter.split(",");
                		if (valuesGet.length == 2 && valuesGet[1].matches("[0-9]+")) {
                			withdrawCash(valuesGet[0], Integer.parseInt(valuesGet[1]));
                		}
                		break;
                	
                	case "PUT":
                		String[] valuesPut = parameter.split(",");
                		if (valuesPut.length == 2 && valuesPut[1].matches("[0-9]+")) {
                			depositCash(valuesPut[0], Integer.parseInt(valuesPut[1]));
                		}
                		break;
                		
                }
            }
        }
        scanner.close();
    }
    
	
    public void close() {
        pwLog.close();
    }
    
}
