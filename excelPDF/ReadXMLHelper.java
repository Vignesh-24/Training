package excelPDF;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ReadXMLHelper {
	
	
	public Element parseXML(String xmlfile) throws Exception {
		// TODO Auto-generated method stub
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setValidating(true);
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document doc=db.parse(xmlfile);
		Element rootElement=doc.getDocumentElement();
		return rootElement;
	}

}
