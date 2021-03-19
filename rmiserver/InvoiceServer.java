package rmiserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import rmiserver.backend.CustomerMasterDAOImpl;
import rmiserver.backend.CustomerMasterDTO;
import rmiserver.backend.InvoiceMasterDAOImpl;
import rmiserver.backend.InvoiceMasterDTO;
import rmiserver.backend.ItemMasterDAOImpl;
import rmiserver.backend.ItemMasterDTO;
import rmiserver.backend.ItemTransactionDAOImpl;
import rmiserver.backend.ItemTransactionDTO;
import rmiserver.utility.consignment.ConsignmentUtility;
import rmiserver.utility.xml.InvoiceWrapper;
import rmiserver.utility.xml.XmlCreator;




public class InvoiceServer extends UnicastRemoteObject implements Invoice{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	InvoiceMasterDAOImpl invoice;
	ItemMasterDAOImpl items;
	CustomerMasterDAOImpl customers;
	ItemTransactionDAOImpl impl;
	
	
	public void startInvoiceApp() throws RemoteException {
		this.invoice=new InvoiceMasterDAOImpl();
		this.items=new ItemMasterDAOImpl();
		this.impl=new ItemTransactionDAOImpl();
		this.customers=new CustomerMasterDAOImpl();
	}
	  
	
	public InvoiceServer() throws RemoteException{
		startInvoiceApp();
	}
	
	
	public void createInvoice(int custno,int invno,Map<Integer, Integer> map) throws RemoteException {
		System.out.println("create invoice logic executed.....");
		invno=invoice.insertInvoice(new InvoiceMasterDTO(invno,new Date(System.currentTimeMillis()),custno));
		for(Integer keys: map.keySet()) {
			impl.insertNewTransaction(new ItemTransactionDTO(invno,keys,map.get(keys)));
		}
		
	}
	
	
	public void addItem(ItemMasterDTO itemdto)throws RemoteException {
		System.out.println("add item initiated..!");
		items.insertItem(itemdto);
	}
	
	
	public void createXML(int invno) {
		InvoiceMasterDTO inv=invoice.getInvoiceMaster(invno);
		CustomerMasterDTO customer=customers.getCustomer(inv.getCustomerno());
		Set<ItemTransactionDTO> transactionDTOs=impl.getByInvoiceNo(invno);
		Map<Integer, ItemMasterDTO> map=new HashMap<>();
		for(ItemTransactionDTO itrans: transactionDTOs) {
			map.put(itrans.getItemno(), items.getItem(itrans.getItemno()));
		}
		XmlCreator.createXML(new InvoiceWrapper(customer,inv,transactionDTOs,map));
		
	}
	
	@Override
	public void createPDF(int invno) throws RemoteException {
		System.out.println("PDF..");
		createXML(invno);
		
	}


	@Override
	public void createExcel(int invno) throws RemoteException {
		System.out.println("Excel..");
		createXML(invno);
		
	}
	
	public String calculateDate(int invno) throws RemoteException{
		
		InvoiceMasterDTO invoiceMasterDTO=invoice.getInvoiceMaster(invno);
		CustomerMasterDTO cus=customers.getCustomer(invoiceMasterDTO.getCustomerno());
		Properties properties=DBUtiility.getProperty();
		int distance=Integer.parseInt(properties.getProperty(cus.getCustomeraddress().toLowerCase()));
		int speed=Integer.parseInt(properties.getProperty("speed"));
		return new ConsignmentUtility().getDeliveryInfo(distance, speed, invoiceMasterDTO.getInvdate());
		
	}
	
	public void closeApp() {
		DBUtiility.closeConnection(null);
	}


	
}