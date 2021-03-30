package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;


public class ItemMasterDAOImpl implements ItemMasterDAO,Cloneable {
	
	
	private Properties prop;
	private static ItemMasterDAOImpl itemMasterDAOImpl;
	
	private ItemMasterDAOImpl(Properties prop) {
		this.prop=prop;
	}
	
	synchronized public static ItemMasterDAOImpl getItemMasterImpl(Properties prop) {
		if(itemMasterDAOImpl==null) {
			itemMasterDAOImpl=new ItemMasterDAOImpl(prop);
			return itemMasterDAOImpl;
		}
		else
			return itemMasterDAOImpl.createClone();
		
	}
	
	public ItemMasterDAOImpl createClone() {
		try {
			return (ItemMasterDAOImpl)super.clone();
		}catch(Exception e) {
			return null;
		}
	}
	
	

	@Override
	public int insertItem(ItemMasterDTO item) {
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("Insert into itemmaster values(null,?,?,?,?,?)");
			stmt.setString(1, item.getItemdesc());
			stmt.setFloat(2, item.getItemprice());
			stmt.setInt(3, item.getItemqty());
			stmt.setString(4, item.getCategory());
			stmt.setString(5, item.getImg());
			stmt.execute();
			DBUtility.closeConnection(null);
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	
		return 1;
	}

	@Override
	public int deleteItem(int itemno) {
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("Delete from itemmaster where itemno=?");
			stmt.setInt(1, itemno);
			stmt.execute();
			DBUtility.closeConnection(null);
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
		
		return 1;
	}
	
	@Override
	public int updateItem(ItemMasterDTO item) {
		
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("update itemmaster set itemdesc=?,itemprice=?,itemqty=?,itmcat=?,img=? where itemno=?");		
			stmt.setString(1, item.getItemdesc());
			stmt.setFloat(2, item.getItemprice());
			stmt.setInt(3, item.getItemqty());
			stmt.setInt(6, item.getItemno());
			stmt.setString(4, item.getCategory());
			stmt.setString(5, item.getImg());
			stmt.execute();
			DBUtility.closeConnection(null);
			
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
		
		return 1;
	}

	
	@Override
	public ItemMasterDTO getItem(int itemno) {
		
		ItemMasterDTO itemdto=new ItemMasterDTO();
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("select * from itemmaster where itemno=?");
			stmt.setInt(1, itemno);
			ResultSet res=stmt.executeQuery();
			
			while(res.next()) {
				itemdto.setItemno(res.getInt(1));
				itemdto.setItemdesc(res.getString(2));
				itemdto.setItemprice(res.getFloat(3));
				itemdto.setItemqty(res.getInt(4));
				itemdto.setCategory(res.getString(5));
				itemdto.setImg(res.getString(6));
				
			}
			DBUtility.closeConnection(null);
			return itemdto;
			
		}catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
		
	}

	@Override
	public Set<ItemMasterDTO> getAllItems() {
		
		Set<ItemMasterDTO> items=new HashSet<>();
		
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("select * from itemmaster");
			ResultSet res=stmt.executeQuery();
			
			while(res.next()) {
				ItemMasterDTO itemdto=new ItemMasterDTO();
				itemdto.setItemno(res.getInt(1));
				itemdto.setItemdesc(res.getString(2));
				itemdto.setItemprice(res.getFloat(3));
				itemdto.setItemqty(res.getInt(4));
				itemdto.setCategory(res.getString(5));
				itemdto.setImg(res.getString(6));
				items.add(itemdto);
			}
			DBUtility.closeConnection(null);
			return items;
			
		}catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
		
	}
	
	@Override
	public Set<ItemMasterDTO> getItemsByCategory(String category) {
		
		Set<ItemMasterDTO> items=new HashSet<>();
		
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("select * from itemmaster where itmcat=?");
			stmt.setString(1, category);
			ResultSet res=stmt.executeQuery();
			
			while(res.next()) {
				ItemMasterDTO itemdto=new ItemMasterDTO();
				itemdto.setItemno(res.getInt(1));
				itemdto.setItemdesc(res.getString(2));
				itemdto.setItemprice(res.getFloat(3));
				itemdto.setItemqty(res.getInt(4));
				itemdto.setCategory(res.getString(5));
				itemdto.setImg(res.getString(6));
				items.add(itemdto);
			}
			DBUtility.closeConnection(null);
			return items;
			
		}catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
		
	}



}
