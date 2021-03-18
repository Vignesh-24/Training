package rmiserver;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class InvoiceLoader {

	public static void main(String[] args) throws Exception {
		
		InvoiceServer is=new InvoiceServer();
		LocateRegistry.createRegistry(1099);
		System.out.println("Invoice app ready...");
		Naming.bind("rmi://localhost:1099/myinvoiceapp", is);

	}

}
