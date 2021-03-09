package excelPDF;

import java.lang.reflect.Proxy;

public class Demo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Object xml=new Demo();
		xml=Proxy.newProxyInstance(Demo.class.getClassLoader(),new Class[] {TextToExcel.class},new NewInvocationHandler(
				new ExcelHelper()));
		TextToExcel writer=(TextToExcel)xml;
		writer.writeToExcel("src/excelPDF/bill.xml");
		
		xml=Proxy.newProxyInstance(Demo.class.getClassLoader(),new Class[] {TextToPDF.class},new NewInvocationHandler(
				new PDFHelper()));
		TextToPDF writerpdf=(TextToPDF)xml;
		writerpdf.writeToPDF("src/excelPDF/bill.xml");

	}

}
