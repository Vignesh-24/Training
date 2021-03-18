package rmiserver.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import day21.DBUtiility;

public class ItemTransactionDAOImpl implements ItemTransactionDAO{

	Connection con=null;
	PreparedStatement stmt;
	
	public void connect() {
		this.con=DBUtiility.getConnection();
	}
	
	public ItemTransactionDAOImpl() {
		connect();
	}
	
	
	@Override
	public int insertNewTransaction(ItemTransactionDTO itm) {
		
		try {
			stmt=con.prepareStatement("Insert into itemtransaction values(?,?,?)");
			stmt.setInt(1, itm.getInvno());
			stmt.setInt(2, itm.getItemno());
			stmt.setInt(3, itm.getItemunit());
			stmt.execute();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
		
	}

	@Override
	public int deleteTransaction(int invno, int itemno) {
		try {
			stmt=con.prepareStatement("Delete from itemtransaction where itemno=? and invno=?");
			stmt.setInt(1, itemno);
			stmt.setInt(2, invno);
			stmt.execute();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}

	@Override
	public ItemTransactionDTO getTransaction(int invno, int itemno) {
		
		try {
			
			ItemTransactionDTO idto=new ItemTransactionDTO();
			stmt=con.prepareStatement("select * from itemtransaction where invno=? and itemno=?");
			stmt.setInt(1, invno);
			stmt.setInt(2, itemno);
			ResultSet res=stmt.executeQuery();
			
			while(res.next()) {
				idto.setInvno(res.getInt(1));
				idto.setItemno(res.getInt(2));
				idto.setItemunit(res.getInt(3));
			}
			
			return idto;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateTransaction(ItemTransactionDTO itm) {
		
		try {
			stmt=con.prepareStatement("update itemtransaction set itemno=?,itemunit=? where invno=?");
			stmt.setInt(3, itm.getInvno());
			stmt.setInt(1, itm.getItemno());
			stmt.setInt(2, itm.getItemunit());
			stmt.execute();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}

	@Override
	public Set<ItemTransactionDTO> getAllTransactions() {
		Set<ItemTransactionDTO> transactionDTOs=new HashSet<>();
		
		try {

			stmt=con.prepareStatement("select * from itemtransaction");
			ResultSet res=stmt.executeQuery();
			
			while(res.next()) {
				ItemTransactionDTO idto=new ItemTransactionDTO();
				idto.setInvno(res.getInt(1));
				idto.setItemno(res.getInt(2));
				idto.setItemunit(res.getInt(3));
				transactionDTOs.add(idto);
			}
			
			return transactionDTOs;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Set<ItemTransactionDTO> getByInvoiceNo(int invno){
		
		Set<ItemTransactionDTO> transactionDTOs=new HashSet<>();
		
		try {

			stmt=con.prepareStatement("select * from itemtransaction where invno=?");
			stmt.setInt(1, invno);
			ResultSet res=stmt.executeQuery();

			while(res.next()) {
				ItemTransactionDTO idto=new ItemTransactionDTO();
				idto.setInvno(res.getInt(1));
				idto.setItemno(res.getInt(2));
				idto.setItemunit(res.getInt(3));
				transactionDTOs.add(idto);
			}
			
			return transactionDTOs;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public void close() {
		DBUtiility.closeConnection(null);
	}

}
