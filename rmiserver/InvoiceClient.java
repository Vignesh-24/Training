package rmiserver;

import java.lang.reflect.Proxy;
import java.rmi.Naming;
import java.util.Scanner;

import rmiserver.utility.excel.ExcelWriter;
import rmiserver.utility.excel.XMLtoExcel;
import rmiserver.utility.pdf.PDFWriter;
import rmiserver.utility.pdf.XMLtoPDF;

public class InvoiceClient {
	
	public static void main(String[] args) throws Exception{
		Object obj=new InvoiceClient();
		obj=Proxy.newProxyInstance(InvoiceClient.class.getClassLoader(),new Class[] {XMLtoPDF.class,XMLtoExcel.class},
				new NewInvocationHandler(new Object[] {new PDFWriter(),new ExcelWriter()}));
		Invoice inv=(Invoice)Naming.lookup("rmi://localhost:1099/myinvoiceapp");
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("Please select your choice...");
			System.out.println("1-Create new Invoice");
			System.out.println("2-Calculate Delivery date and time");
			System.out.println("3-Create PDF");
			System.out.println("4-Create Excel");
			System.out.println("5-New Item");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:{
				ClientHelper.createInvoiceHelper(inv,scan);
				break;
			}
			case 2:{
				System.out.println("enter invoice no:");
				int invno=scan.nextInt();
				System.out.println("Delivery Info: "+inv.calculateDate(invno));
				break;
			}
			case 3:{
				System.out.println("enter invoice no:");
				int invno=scan.nextInt();
				inv.createPDF(invno);
				XMLtoPDF pdf=(XMLtoPDF)obj;
				System.out.println("PDF Creation Initiated...");
				pdf.writeToPDF("src/rmiserver/"+invno+".xml");
				break;
			}
			case 4:{
				System.out.println("enter invoice no:");
				int invno=scan.nextInt();
				inv.createExcel(invno);
				XMLtoExcel excel=(XMLtoExcel)obj;
				excel.writeToExcel("src/rmiserver/"+invno+".xml");
				break;
			}
			case 5:
				ClientHelper.createItem(inv, scan);break;
			default:
				inv.closeApp();;System.exit(1);
			}
			
			
		}
		
		
		
	}

}
