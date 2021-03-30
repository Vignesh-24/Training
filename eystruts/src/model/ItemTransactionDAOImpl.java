package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class ItemTransactionDAOImpl implements ItemTransactionDAO, Cloneable{
	
	private Properties prop;
	private static ItemTransactionDAOImpl itemTransactionDAOImpl;

	private ItemTransactionDAOImpl(Properties prop) {
		this.prop=prop;
	}
	
	
	synchronized public static ItemTransactionDAOImpl getItemTransactionDAO(Properties prop) {
		if(itemTransactionDAOImpl==null) { 
			itemTransactionDAOImpl=new ItemTransactionDAOImpl(prop);
			return itemTransactionDAOImpl;}
		else
			return itemTransactionDAOImpl.createClone();
	}
	

	public ItemTransactionDAOImpl createClone() {
		try {
			return (ItemTransactionDAOImpl)super.clone();
		}catch(Exception e) {
			return null;
		}
	}
	
	
	@Override
	public int insertNewTransaction(ItemTransactionDTO itm) {
		
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("Insert into itemtransaction values(?,?,?)");
			stmt.setInt(1, itm.getInvno());
			stmt.setInt(2, itm.getItemno());
			stmt.setInt(3, itm.getItemunit());
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
	public int deleteTransaction(int invno, int itemno) {
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("Delete from itemtransaction where itemno=? and invno=?");
			stmt.setInt(1, itemno);
			stmt.setInt(2, invno);
			stmt.execute();
			DBUtility.closeConnection(null);
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}

	@Override
	public ItemTransactionDTO getTransaction(int invno, int itemno) {
		
		try {
			Connection con=DBUtility.getConnection(prop);
			ItemTransactionDTO idto=new ItemTransactionDTO();
			PreparedStatement stmt=con.prepareStatement("select * from itemtransaction where invno=? and itemno=?");
			stmt.setInt(1, invno);
			stmt.setInt(2, itemno);
			ResultSet res=stmt.executeQuery();
			
			while(res.next()) {
				idto.setInvno(res.getInt(1));
				idto.setItemno(res.getInt(2));
				idto.setItemunit(res.getInt(3));
			}
			DBUtility.closeConnection(null);
			return idto;
			
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateTransaction(ItemTransactionDTO itm) {
		
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("update itemtransaction set itemno=?,itemunit=? where invno=?");
			stmt.setInt(3, itm.getInvno());
			stmt.setInt(1, itm.getItemno());
			stmt.setInt(2, itm.getItemunit());
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
	public Set<ItemTransactionDTO> getAllTransactions() {
		Set<ItemTransactionDTO> transactionDTOs=new HashSet<>();
		
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("select * from itemtransaction");
			ResultSet res=stmt.executeQuery();
			
			while(res.next()) {
				ItemTransactionDTO idto=new ItemTransactionDTO();
				idto.setInvno(res.getInt(1));
				idto.setItemno(res.getInt(2));
				idto.setItemunit(res.getInt(3));
				transactionDTOs.add(idto);
			}
			DBUtility.closeConnection(null);
			return transactionDTOs;
			
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
		
	}
	
	public Set<ItemTransactionDTO> getByInvoiceNo(int invno){
		
		Set<ItemTransactionDTO> transactionDTOs=new HashSet<>();
		
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("select * from itemtransaction where invno=?");
			stmt.setInt(1, invno);
			ResultSet res=stmt.executeQuery();

			while(res.next()) {
				ItemTransactionDTO idto=new ItemTransactionDTO();
				idto.setInvno(res.getInt(1));
				idto.setItemno(res.getInt(2));
				idto.setItemunit(res.getInt(3));
				transactionDTOs.add(idto);
			}
			DBUtility.closeConnection(null);
			return transactionDTOs;
			
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
		
		
	}
	

}
