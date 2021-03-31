package service;


import java.util.Map;
import java.util.Set;
import model.ItemMasterDTO;
import utility.parser.InvoiceWrapper;



public interface ShopService {
	
	public Set<ItemMasterDTO> loadAllItems();
	public Set<ItemMasterDTO> loadByCategory(String category);
	public InvoiceWrapper buy(String user,Map<Integer, Integer> map);
	public void sendEmail(int invno);
	public void getPDF(int invno);
	public void getExcel(int invno);
	public void sendMsg(int invno);

}
