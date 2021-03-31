package utility.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.ItemMasterDTO;
import model.ItemTransactionDTO;
import utility.parser.InvoiceWrapper;
import utility.parser.ParserHelper;



public class PDFWriter implements XMLtoPDF{

	@Override
	public void writeToPDF(String xmlfile) throws Exception {
		 InvoiceWrapper data=ParserHelper.getInvoiceData(xmlfile);
		 File file=new File(data.getInvoice().getInvno()+"_invoice.pdf");
		 if(file.exists())
				return;
		 
		 Document document = new Document();
		 PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
		 document.open();
	     PdfPTable table = new PdfPTable(6); 
	     table.setWidthPercentage(100); 
	     table.setSpacingBefore(10f); 
	     table.setSpacingAfter(10f); 
	    
	     
	     //header
	     Paragraph name=new Paragraph("NAME: "+data.getCustomer().getCustomername());
	     Paragraph email=new Paragraph("EMAIL: "+data.getCustomer().getCustomeremail());
	     Paragraph number=new Paragraph("PHONE: "+String.valueOf(data.getCustomer().getCustomerphone()));
	  
	
	     Paragraph num=new Paragraph("INVOICE NO: "+String.valueOf(data.getInvoice().getInvno()));
	     Paragraph date=new Paragraph("DATE: "+data.getInvoice().getInvdate().toString());
	     
	     document.add(name);
	     document.add(email);
	     document.add(number);
	     document.add(num);
	     document.add(date);
	     //table heading
	     this.createCell("ID", table);
	     this.createCell("NAME", table);
	     this.createCell("UNIT", table);
	     this.createCell("PRICE", table);
	     this.createCell("QTY", table);
	     this.createCell("AMOUNT", table);
	     
	     float total=0;
	     Map<Integer, ItemMasterDTO> map=data.getItemlist();
	     //content
	     for(ItemTransactionDTO itemtrans: data.getItemtrans()) {
	    	 
	    	 ItemMasterDTO item=map.get(itemtrans.getItemno());
	    	 this.createCell(String.valueOf(item.getItemno()), table);
	    	 this.createCell(item.getItemdesc(), table);
	    	 this.createCell(String.valueOf(item.getItemqty()), table);
	    	 this.createCell(String.valueOf(item.getItemprice()), table);
	    	 this.createCell(String.valueOf(itemtrans.getItemunit()), table);
	    	 float price=itemtrans.getItemunit()*item.getItemprice();
	    	 this.createCell(String.valueOf(price), table);
	    	 total+=price;
	     }
	     this.createCell("", table);
	     this.createCell("", table);
	     this.createCell("", table);
	     this.createCell("", table);
	     this.createCell("Total Amount", table);this.createCell(String.valueOf(total), table);
	     document.add(table);
	     Paragraph paragraph=new Paragraph("ADDRESS: "+data.getCustomer().getCustomeraddress());
	     document.add(paragraph);
	     document.close();
	     writer.close();
	     System.out.println("PDF Created..!");
	}
	
	
	private void createCell(String content,PdfPTable table) {
		
		 PdfPCell cell = new PdfPCell(new Paragraph(content));
 		        cell.setBorderColor(BaseColor.BLACK);
 		        cell.setPaddingLeft(10);
 		        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
 		        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
 		        table.addCell(cell);
		

	}

}
