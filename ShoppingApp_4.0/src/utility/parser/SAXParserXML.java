package utility.parser;


import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.CustomerMasterDTO;
import model.InvoiceMasterDTO;
import model.ItemMasterDTO;
import model.ItemTransactionDTO;


public class SAXParserXML extends DefaultHandler{
	
	String curvalue;
	InvoiceWrapper wrapper;
	ItemMasterDTO item;
	ItemTransactionDTO itrans;
	CustomerMasterDTO customer;
	InvoiceMasterDTO invoice;
	
	Set<ItemTransactionDTO>itransdto=new HashSet<>();
	Map<Integer, ItemMasterDTO> items=new HashMap<>();
	
	public SAXParserXML() {
		this.wrapper=new InvoiceWrapper();
	}
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Document Parsing Started..");
		customer=new CustomerMasterDTO();
		invoice=new InvoiceMasterDTO();
	}
	
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equals("item")) {
			this.item=new ItemMasterDTO();
			this.itrans=new ItemTransactionDTO();
		}
	}
	
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		curvalue=new String(ch, start, length);
		
	}
	
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		switch(qName) {
		case "itemno":this.item.setItemno(Integer.parseInt(curvalue));itrans.setItemno(Integer.parseInt(curvalue));break;
		case "itemdesc":this.item.setItemdesc(curvalue);break;
		case "unit":this.item.setItemqty(Integer.parseInt(curvalue));break;
		case "itemprice":this.item.setItemprice(Float.parseFloat(curvalue));break;
		case "qty":this.itrans.setItemunit(Integer.parseInt(curvalue));this.itrans.setInvno(this.invoice.getInvno());break;
		case "custaddress":this.customer.setCustomeraddress(curvalue);break;
		case "customeremail":this.customer.setCustomeremail(curvalue);break;
		case "custname":this.customer.setCustomername(curvalue);break;
		case "customerphn":this.customer.setCustomerphone(Long.parseLong(curvalue));break;
		case "invoiceno":this.invoice.setInvno(Integer.parseInt(curvalue));break;
		case "invoicedate":try{SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf.parse(curvalue);
			this.invoice.setInvdate(new java.sql.Date(date.getTime()));break;}catch(Exception e) {}
		case "item":this.items.put(item.getItemno(), item);this.itransdto.add(itrans);break; 
		
		}
		
	}
	
	
	
	@Override
	public void endDocument() throws SAXException {
		wrapper.setCustomer(customer);
		wrapper.setInvoice(invoice);
		wrapper.setItemlist(items);
		wrapper.setItemtrans(itransdto);
		System.out.println("Document Parsing Ended..");
	}
	
	public InvoiceWrapper getInvoiceData() {
		return this.wrapper;
		
	}

}
