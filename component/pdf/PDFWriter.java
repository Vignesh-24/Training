package component.pdf;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import component.parser.InvoiceWrapper;
import component.parser.Item;
import component.parser.ParserHelper;

public class PDFWriter implements XMLtoPDF{

	@Override
	public void writeToPDF(String xmlfile) throws Exception {
		
		 Document document = new Document();
		 PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("src/component/pdf/invoice.pdf"));
		 document.open();
	     PdfPTable table = new PdfPTable(6); 
	     table.setWidthPercentage(100); 
	     table.setSpacingBefore(10f); 
	     table.setSpacingAfter(10f); 
	     InvoiceWrapper data=ParserHelper.getInvoiceData(xmlfile);
	     
	     //header
	     this.createCell("NAME", table);
	     this.createCell(data.getCustomer().getName(), table);
	     this.createCell("BILL ID", table);
	     this.createCell(data.getCustomer().getBillid(), table);
	     this.createCell("BILL DATE", table);
	     this.createCell(data.getCustomer().getBilldate(), table);
	     
	     
	     //table heading
	     this.createCell("ID", table);
	     this.createCell("NAME", table);
	     this.createCell("UNIT", table);
	     this.createCell("PRICE", table);
	     this.createCell("QTY", table);
	     this.createCell("AMOUNT", table);
	     
	     int total=0;
	     //content
	     for(Item item: data.getItems()) {
	    	 this.createCell(String.valueOf(item.getId()), table);
	    	 this.createCell(item.getName(), table);
	    	 this.createCell(String.valueOf(item.getUnit()), table);
	    	 this.createCell(String.valueOf(item.getPrice()), table);
	    	 this.createCell(String.valueOf(item.getQty()), table);
	    	 this.createCell(String.valueOf(item.getAmount()), table);
	    	 total+=item.getAmount();
	     }
	     this.createCell("", table);
	     this.createCell("", table);
	     this.createCell("", table);
	     this.createCell("", table);
	     this.createCell("Total Amount", table);this.createCell(String.valueOf(total), table);
	     document.add(table);
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
