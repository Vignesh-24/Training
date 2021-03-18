package day22;

import java.util.Set;

public interface ItemMasterDAO {
	
	public int insertItem(ItemMasterDTO item);
	public int deleteItem(int itemno);
	public int updateItem(ItemMasterDTO item);
	public ItemMasterDTO getItem(int itemno);
	public Set<ItemMasterDTO> getAllItems();
	

}
