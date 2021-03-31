package service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import model.CustomerMasterDTO;
import model.CustomerDAOImpl;
import model.InvoiceMasterDAO;
import model.InvoiceMasterDAOImpl;
import model.InvoiceMasterDTO;
import model.ItemMasterDAO;
import model.ItemMasterDAOImpl;
import model.ItemMasterDTO;
import model.ItemTransactionDAO;
import model.ItemTransactionDAOImpl;
import model.ItemTransactionDTO;
import model.UserDAOImpl;
import utility.parser.InvoiceWrapper;
import utility.pdf.PDFWriter;
import utility.pdf.XMLtoPDF;
import utility.sms.MessageSender;
import utility.sms.XMLtoSMS;
import utility.XmlCreator;
import utility.excel.ExcelWriter;
import utility.excel.XMLtoExcel;
import utility.mail.MailSender;
import utility.mail.XMLtoEmail;


public class ShopServiceImpl implements ShopService,Cloneable{
	
	
	private Properties prop;
	private static ShopServiceImpl shopservice;
	
	private ShopServiceImpl(Properties prop) {
		this.prop=prop;
	}
	
	synchronized public static ShopServiceImpl getShopService(Properties prop) {
		if(shopservice==null) {
			shopservice=new ShopServiceImpl(prop);
			return shopservice;
		}
		else {
			return shopservice.createClone();
		}
		
	}
	
	public ShopServiceImpl createClone() {
		try {
			return (ShopServiceImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Set<ItemMasterDTO> loadAllItems() {
		ItemMasterDAO itemDAO=ItemMasterDAOImpl.getItemMasterImpl(prop);
		return itemDAO.getAllItems();
	}

	@Override
	public Set<ItemMasterDTO> loadByCategory(String category) {
		ItemMasterDAO itemDAO=ItemMasterDAOImpl.getItemMasterImpl(prop);
		return itemDAO.getItemsByCategory(category);
	}
	
	@Override
	public InvoiceWrapper buy(String username,Map<Integer, Integer> map) {
		
		InvoiceMasterDAO invoice=InvoiceMasterDAOImpl.getInvoiceMasterImpl(prop);
		int custno=UserDAOImpl.getUserDAOImpl(prop).getUserByName(username).getUid();
		
		//invno num passed is dummy
		int invno=invoice.insertInvoice(new InvoiceMasterDTO(-1,new Date(System.currentTimeMillis()),custno));
		ItemTransactionDAO impl=ItemTransactionDAOImpl.getItemTransactionDAO(prop);
		for(Integer keys: map.keySet()) {
			impl.insertNewTransaction(new ItemTransactionDTO(invno,keys,map.get(keys)));
		}
		
		return createInvoiceWrapper(invno);
	}
	
	
	private InvoiceWrapper createInvoiceWrapper(int invno) {
		InvoiceMasterDTO inv=InvoiceMasterDAOImpl.getInvoiceMasterImpl(prop).getInvoiceMaster(invno);
		CustomerMasterDTO customer=CustomerDAOImpl.getCustomerImpl(prop).getCustomer(inv.getCustomerno());
		Set<ItemTransactionDTO> transactionDTOs=ItemTransactionDAOImpl.getItemTransactionDAO(prop).getByInvoiceNo(invno);
		ItemMasterDAO items=ItemMasterDAOImpl.getItemMasterImpl(prop);
		Map<Integer, ItemMasterDTO> map=new HashMap<>();
		for(ItemTransactionDTO itrans: transactionDTOs) {
			map.put(itrans.getItemno(), items.getItem(itrans.getItemno()));
		}
		
		InvoiceWrapper invoiceWrapper=new InvoiceWrapper(customer, inv, transactionDTOs, map);
		XmlCreator.createXML(invoiceWrapper);
		return invoiceWrapper;
	}

	@Override
	public void sendEmail(int invno) {
		getPDF(invno);
		XMLtoEmail email=new MailSender();
		try {
			email.sendEmail("vicky241299@gmail.com", String.valueOf(invno)+"_invoice.pdf");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getPDF(int invno) {
		XMLtoPDF pdf=new PDFWriter();
		try {
			pdf.writeToPDF(String.valueOf(invno)+".xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getExcel(int invno) {
		XMLtoExcel excel=new ExcelWriter();
		try {
			excel.writeToExcel(String.valueOf(invno)+".xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void sendMsg(int invno) {
		XMLtoSMS  sms=new MessageSender();
		try {
			sms.sendSMS("+918072868279",String.valueOf(invno)+".xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
