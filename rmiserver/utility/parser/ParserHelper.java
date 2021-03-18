package rmiserver.utility.parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import rmiserver.utility.xml.InvoiceWrapper;


public class ParserHelper {
	
	public static InvoiceWrapper getInvoiceData(String filename) {
		
		SAXParserFactory spf=SAXParserFactory.newInstance();
		
		try {
			
			SAXParser parser=spf.newSAXParser();
			SAXParserXML sml=new SAXParserXML();
			parser.parse(filename, sml);
			return sml.getInvoiceData();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return null;
			
		}
		
	}

}
