package excelPDF;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFHelper implements TextToPDF {
	

	
	
	public static void main(String[] args) throws Exception
	{
	    
	 new PDFHelper().writeToPDF("src/excelPDF/bill.xml");
	 
	}
	
	
	
	
	
	
	
	

	@Override
	public void writeToPDF(String xmlfile) throws Exception {
		// TODO Auto-generated method stub
		org.w3c.dom.Element root=new ReadXMLHelper().parseXML(xmlfile);
		 try
		    {
		    	Document document = new Document();
		        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("src/excelPDF/output.pdf"));
		        document.open();
		        PdfPTable table = new PdfPTable(root.getChildNodes().item(0).getChildNodes().getLength()); 
		        table.setWidthPercentage(100); 
		        table.setSpacingBefore(10f); 
		        table.setSpacingAfter(10f); 
		        
		        for(int j=0;j<root.getChildNodes().item(0).getChildNodes().getLength();j++) {
		        	 PdfPCell cell = new PdfPCell(new Paragraph(
			    				root.getChildNodes().item(0).getChildNodes().item(j).getNodeName()));
			    		        cell.setBorderColor(BaseColor.BLACK);
			    		        cell.setPaddingLeft(10);
			    		        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    		        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			    		        table.addCell(cell);
		        }
		        
		    	for(int i=0;i<root.getChildNodes().getLength();i++) {
		    		
		    		
		    		for(int j=0;j<root.getChildNodes().item(i).getChildNodes().getLength();j++) {
		    			
		    		
		    			 PdfPCell cell = new PdfPCell(new Paragraph(
		    				root.getChildNodes().item(i).getChildNodes().item(j).getFirstChild().getNodeValue()));
		    		        cell.setBorderColor(BaseColor.BLACK);
		    		        cell.setPaddingLeft(10);
		    		        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		    		        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		    		        table.addCell(cell);
		    			
		    		}
		    		
		    		
		    	}
		    	
		    	document.add(table);
		        document.close();
		        writer.close();
		    }
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		
	}

}
