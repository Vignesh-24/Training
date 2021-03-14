package component.excel;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import component.parser.InvoiceWrapper;
import component.parser.Item;
import component.parser.ParserHelper;

public class ExcelWriter implements XMLtoExcel{

	
	@Override
	public void writeToExcel(String xmlfile) throws Exception {
		
		HSSFWorkbook workbook=new HSSFWorkbook();
		String filename = "src/component/excel//Invoice.xls";
		HSSFSheet sheet=workbook.createSheet("Bill Details");
		InvoiceWrapper data=ParserHelper.getInvoiceData(xmlfile);
		HSSFRow heading=sheet.createRow(0);
		
		heading.createCell(0).setCellValue("Name");
		heading.createCell(1).setCellValue(data.getCustomer().getName());
		
		heading.createCell(2).setCellValue("Bill ID");
		heading.createCell(3).setCellValue(data.getCustomer().getBillid());
		
		heading.createCell(4).setCellValue("Bill Date");
		heading.createCell(5).setCellValue(data.getCustomer().getBilldate());
		sheet.createRow(1);
		HSSFRow row=sheet.createRow(2);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("UNIT");
		row.createCell(3).setCellValue("PRICE");
		row.createCell(4).setCellValue("QTY");
		row.createCell(5).setCellValue("AMOUNT");
		
		int itr=3;
		int col=0;
		int total=0;
		for(Item item: data.getItems()) {
			
			row=sheet.createRow(itr);
			row.createCell(col++).setCellValue(item.getId());
			row.createCell(col++).setCellValue(item.getName());
			row.createCell(col++).setCellValue(item.getUnit());
			row.createCell(col++).setCellValue(item.getPrice());
			row.createCell(col++).setCellValue(item.getQty());
			row.createCell(col++).setCellValue(item.getAmount());
			total+=item.getAmount();
			col=0;
			itr++;
			
		}
		
		//empty row
		sheet.createRow(itr++);
		row=sheet.createRow(itr);
		row.createCell(0).setCellValue("Total: ");
		row.createCell(1).setCellValue(total);
		
		FileOutputStream fileOut = new FileOutputStream(filename);  
		workbook.write(fileOut); 
		fileOut.close();  
		workbook.close(); 
		System.out.println("Excel Created...!");
		
		
	}

}
