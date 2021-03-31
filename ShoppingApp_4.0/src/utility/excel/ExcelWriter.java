package utility.excel;

import java.io.FileOutputStream;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import model.ItemMasterDTO;
import model.ItemTransactionDTO;
import utility.parser.InvoiceWrapper;
import utility.parser.ParserHelper;


public class ExcelWriter implements XMLtoExcel{

	
	@Override
	public void writeToExcel(String xmlfile) throws Exception {
		
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet("Bill Details");
		InvoiceWrapper data=ParserHelper.getInvoiceData(xmlfile);
		HSSFRow heading=sheet.createRow(0);
		String filename = data.getInvoice().getInvno()+"_Invoice.xls";
		heading.createCell(0).setCellValue("Name");
		heading.createCell(1).setCellValue(data.getCustomer().getCustomername());
		
		heading.createCell(2).setCellValue("Invoicr Nmber");
		heading.createCell(3).setCellValue(data.getInvoice().getInvno());
		
		heading.createCell(4).setCellValue("Bill Date");
		heading.createCell(5).setCellValue(data.getInvoice().getInvdate().toString());
		
		
		heading.createCell(6).setCellValue("Email");
		heading.createCell(7).setCellValue(data.getCustomer().getCustomeremail());
		
		heading.createCell(6).setCellValue("Mobile");
		heading.createCell(7).setCellValue(data.getCustomer().getCustomerphone());
		
		
		
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
		float total=0;
		Map<Integer, ItemMasterDTO> map=data.getItemlist();
		for(ItemTransactionDTO itemtrans: data.getItemtrans()) {
			
			row=sheet.createRow(itr);
			ItemMasterDTO item=map.get(itemtrans.getItemno());
			row.createCell(col++).setCellValue(item.getItemno());
			row.createCell(col++).setCellValue(item.getItemdesc());
			row.createCell(col++).setCellValue(item.getItemqty());
			row.createCell(col++).setCellValue(item.getItemprice());
			row.createCell(col++).setCellValue(itemtrans.getItemunit());
			float price=itemtrans.getItemunit()*item.getItemprice();
			row.createCell(col++).setCellValue(price);
			total+=price;
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
