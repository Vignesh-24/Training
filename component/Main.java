package component;

import java.lang.reflect.Proxy;
import java.util.Scanner;

import component.excel.ExcelWriter;
import component.excel.XMLtoExcel;
import component.mail.MailSender;
import component.mail.XMLtoEmail;
import component.pdf.PDFWriter;
import component.pdf.XMLtoPDF;


public class Main {

	public static void main(String[] args) throws Exception {
		
		Object obj=new Main();
		obj=Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[] {XMLtoExcel.class,XMLtoPDF.class, XMLtoEmail.class}, 
				new NewInvocationHandler(
				new Object[]{new ExcelWriter(),new PDFWriter(), new MailSender()}));
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Select Choice\n1.Excel\n2.PDF\n3.Email\n");
		int n=sc.nextInt();
		
		
		switch (n) {
		case 1:
			XMLtoExcel excel=(XMLtoExcel)obj;
			excel.writeToExcel("src/component/bill.xml");
			break;
		case 2:
			XMLtoPDF pdf=(XMLtoPDF)obj;
			pdf.writeToPDF("src/component/bill.xml");
			break;
		case 3:
			XMLtoEmail mail=(XMLtoEmail)obj;
			System.out.println("Enter recipient mail address:\n");
			mail.sendEmail(sc.next(),"src/component/bill.xml");
		default:
			break;
		}
		sc.close();
		
		
	}

}
