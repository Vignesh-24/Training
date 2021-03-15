package component;

import java.lang.reflect.Proxy;
import java.util.Scanner;

import component.excel.ExcelWriter;
import component.excel.XMLtoExcel;
import component.mail.MailSender;
import component.mail.XMLtoEmail;
import component.pdf.PDFWriter;
import component.pdf.XMLtoPDF;
import component.sms.MessageSender;
import component.sms.XMLtoSMS;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Object obj=new Main();
		obj=Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[] {XMLtoExcel.class,XMLtoPDF.class, XMLtoEmail.class,XMLtoSMS.class}, 
				new NewInvocationHandler(
				new Object[]{new ExcelWriter(),new PDFWriter(), new MailSender(),new MessageSender()}));
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Select Choice\n1.Excel\n2.PDF\n3.Email\n4.SMS\n");
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
		case 4:
			XMLtoSMS sms=(XMLtoSMS)obj;
			System.out.println("Enter recipient Phone Number:\n");
			sms.sendSMS(sc.next(),"src/component/bill.xml");
		default:
			break;
		}
		sc.close();
		
		
	}

}
