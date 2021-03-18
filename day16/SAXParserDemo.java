package day16;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SAXParserFactory spf=SAXParserFactory.newInstance();
		try {
			SAXParser parser=spf.newSAXParser();
			parser.parse("src/excelPDF/bill.xml", new MySAXHandler() );
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}


class MySAXHandler extends 	DefaultHandler{
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Parsing Started...");
	}
	 
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.print("<"+qName+">");
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("</"+qName+">");
	}
	

	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		System.out.print(new String(ch, start, length));
	}
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Parsing Ended...");
	}
}