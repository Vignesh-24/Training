package excelPDF;

import java.io.FileOutputStream;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.w3c.dom.Element;



public class ExcelHelper implements TextToExcel {

//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		new ExcelHelper().writeToExcel("src/excel/bill.xml");
//
//	}

	
	@Override
	public void writeToExcel(String xmlfile) throws Exception {
		Element root=new ReadXMLHelper().parseXML(xmlfile);
		HSSFWorkbook workbook=new HSSFWorkbook();
		String filename = "src/excel/Balance.xls";
		HSSFSheet sheet=workbook.createSheet("Bill Details");
		HSSFRow heading,rows;
		heading=sheet.createRow(0);
		
		
		for(int i=0;i<root.getChildNodes().getLength();i++) {
			rows=sheet.createRow(i+1);
			for(int j=0;j<root.getChildNodes().item(i).getChildNodes().getLength();j++) {
				if(i==0) {
					heading.createCell(j).setCellValue(root.getChildNodes().item(i).getChildNodes().item(j).getNodeName());
					System.out.println(root.getChildNodes().item(i).getChildNodes().item(j).getNodeName());
				}
				rows.createCell(j).setCellValue(root.getChildNodes().item(i).getChildNodes().item(j).getFirstChild().getNodeValue());
		}
			
	}
		
		
		FileOutputStream fileOut = new FileOutputStream(filename);  
		workbook.write(fileOut);  
		//closing the Stream  
		fileOut.close();  
		//closing the workbook  
		workbook.close(); 
		System.out.println("Excel Created...!");
		
	
	
	}
	

}
