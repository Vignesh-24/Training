package day15;

import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class WriteExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		HSSFWorkbook workbook=new HSSFWorkbook();
		String filename = "src/day15/Balance.xls";
		HSSFSheet sheet = workbook.createSheet("BillDetails");
		
		
		
		HSSFRow heading=sheet.createRow(0);
		heading.createCell(0).setCellValue("Name: ");
		heading.createCell(1).setCellValue("Vignesh K G");
		heading.createCell(2).setCellValue("BillNo: ");
		heading.createCell(3).setCellValue("ABC231 ");
		heading.createCell(4).setCellValue("BillDate: ");
		heading.createCell(5).setCellValue(new Date().toString());
		
		HSSFRow space=sheet.createRow(1);
		space.createCell(0);
		
		HSSFRow rowhead=sheet.createRow(2);
		rowhead.createCell(0).setCellValue("S.No.");  
		rowhead.createCell(1).setCellValue("Item");  
		rowhead.createCell(2).setCellValue("Unit");  
		rowhead.createCell(3).setCellValue("Price");  
		rowhead.createCell(4).setCellValue("Quantity");  
		rowhead.createCell(5).setCellValue("Amount");
		
		
		//creating the 1st row  
		HSSFRow row = sheet.createRow(3);  
		row.createCell(0).setCellValue("1");  
		row.createCell(1).setCellValue("Daal");  
		row.createCell(2).setCellValue("1 kg");  
		row.createCell(3).setCellValue(100);  
		row.createCell(4).setCellValue(2);
		row.createCell(5).setCellValue(200);
		
		
		//creating the 2nd row  
		HSSFRow row1 = sheet.createRow(4);  
		row1.createCell(0).setCellValue("2");  
		row1.createCell(1).setCellValue("Rice");  
		row1.createCell(2).setCellValue("1 kg");  
		row1.createCell(3).setCellValue(50);  
		row1.createCell(4).setCellValue(10);
		row1.createCell(5).setCellValue(500);
		
		FileOutputStream fileOut = new FileOutputStream(filename);  
		workbook.write(fileOut);  
		//closing the Stream  
		fileOut.close();  
		//closing the workbook  
		workbook.close(); 
		System.out.println("Excel file has been generated successfully.");  
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}

}
