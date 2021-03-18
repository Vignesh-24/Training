package day22;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import day21.DBUtiility;

public class ItemMasterDAOImpl implements ItemMasterDAO {
	
	Connection con=null;
	PreparedStatement stmt;
	
	public void connect() {
		this.con=DBUtiility.getConnection();
	}

	@Override
	public int insertItem(ItemMasterDTO item) {
		
		try {
			
			stmt=con.prepareStatement("Insert into itemmaster values(?,?,?,?)");
			stmt.setInt(1, item.getItemno());
			stmt.setString(2, item.getItemdesc());
			stmt.setFloat(3, item.getItemprice());
			stmt.setInt(4, item.getItemqty());
			stmt.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	
		return 1;
	}

	@Override
	public int deleteItem(int itemno) {
		
		try {
			stmt=con.prepareStatement("Delete from itemmaster where itemno=?");
			stmt.setInt(1, itemno);
			stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}

	@Override
	public int updateItem(ItemMasterDTO item) {
		try {
			stmt=con.prepareStatement("update itemmaster set itemdesc=?,itemprice=?,itemqty=? where itemno=?");		
			stmt.setString(1, item.getItemdesc());
			stmt.setFloat(2, item.getItemprice());
			stmt.setInt(3, item.getItemqty());
			stmt.setInt(4, item.getItemno());
			stmt.execute();
			con.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}

	
	@Override
	public ItemMasterDTO getItem(int itemno) {
		
		ItemMasterDTO itemdto=new ItemMasterDTO();
		try {
			stmt=con.prepareStatement("select * from itemmaster where itemno=?");
			stmt.setInt(1, itemno);
			ResultSet res=stmt.executeQuery();
			
			while(res.next()) {
				itemdto.setItemno(res.getInt(1));
				itemdto.setItemdesc(res.getString(2));
				itemdto.setItemprice(res.getFloat(3));
				itemdto.setItemqty(res.getInt(4));
			}
			
			return itemdto;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Set<ItemMasterDTO> getAllItems() {
		
		Set<ItemMasterDTO> items=new HashSet<>();
		
		try {
			stmt=con.prepareStatement("select * from itemmaster");
			ResultSet res=stmt.executeQuery();
			
			while(res.next()) {
				ItemMasterDTO itemdto=new ItemMasterDTO();
				itemdto.setItemno(res.getInt(1));
				itemdto.setItemdesc(res.getString(2));
				itemdto.setItemprice(res.getFloat(3));
				itemdto.setItemqty(res.getInt(4));
				items.add(itemdto);
			}
			
			return items;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void close() {
		DBUtiility.closeConnection(null);
	}

}
