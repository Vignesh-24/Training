package rmiserver;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import rmiserver.backend.ItemMasterDTO;

public class ClientHelper {
	
	public static void createInvoiceHelper(Invoice inv,Scanner scan) {
		Map<Integer, Integer> map=new HashMap<>();
		System.out.println("Enter Customer ID:");
		int custid=scan.nextInt();
		//System.out.println("Enter Invoice Number:");
		//int invno=scan.nextInt();
		System.out.println("Enter Item Details:");
		int itemno,qty;
		while(true) {
			System.out.println("Enter item no: (-1 to exit)");
			itemno=scan.nextInt();
			if(itemno==-1)
				break;
			System.out.println("Enter Quantity:");
			qty=scan.nextInt();
			map.put(itemno, qty);
		}
		
		try {
			inv.createInvoice(custid, -1, map);
		} catch (RemoteException e) {
			System.out.println("Error in Creating Invoice");
		}
		
		
	}
	
	public static void createItem(Invoice inv,Scanner scan) {
		
		System.out.println("Enter item desc:");
		String desc=scan.next();
		System.out.println("Enter Unit");
		int unit=scan.nextInt();
		System.out.println("Enter Price");
		float price=scan.nextFloat();
		ItemMasterDTO item=new ItemMasterDTO(0,desc,price,unit);
		try {
			inv.addItem(item);
		}catch(RemoteException e) {
			System.out.println("Creation Failed");
		}
		
	}

}
