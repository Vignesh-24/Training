package day22;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import day21.DBUtiility;

public class InvoiceMasterDAOImpl implements InvoiceMasterDAO {

	Connection con=null;
	PreparedStatement stmt;
	
	public void connect() {
		this.con=DBUtiility.getConnection();
	}
	
	@Override
	public int insertInvoice(InvoiceMasterDTO invMasterDTO) {
		try {
			stmt=con.prepareStatement("Insert into invoicemaster values(?,?,?)");
			stmt.setInt(1, invMasterDTO.getInvno());
			stmt.setDate(2, invMasterDTO.getInvdate());
			stmt.setInt(3, invMasterDTO.getCustomerno());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public int deleteInvoice(int invno) {
		
		try {
			stmt=con.prepareStatement("Delete from invoicemaster where invno=?");
			stmt.setInt(1, invno);
			stmt.execute();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int updateInvoice(InvoiceMasterDTO invMasterDTO) {
		if(this.deleteInvoice(invMasterDTO.getInvno())==1 && this.insertInvoice(invMasterDTO)==1)
			return 1;
		return 0;
	}

	@Override
	public InvoiceMasterDTO getInvoiceMaster(int invo) {
		
		try {
			
			InvoiceMasterDTO invoice=new InvoiceMasterDTO();
			stmt=con.prepareStatement("select * from invoicemaster where invno=?");
			stmt.setInt(1, invo);
			ResultSet res=stmt.executeQuery();
			
			while(res.next()) {
				invoice.setInvno(res.getInt(1));
				invoice.setInvdate(res.getDate(2));
				invoice.setCustomerno(res.getInt(3));
			}
			
			return invoice;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public Set<InvoiceMasterDTO> getInvoiceMasterAll() {
		
		try {
			
			Set<InvoiceMasterDTO> invoices=new HashSet<>();
			stmt=con.prepareStatement("select * from invoicemaster");
			ResultSet res=stmt.executeQuery();
			
			while(res.next()) {
				InvoiceMasterDTO invoice=new InvoiceMasterDTO();
				invoice.setInvno(res.getInt(1));
				invoice.setInvdate(res.getDate(2));
				invoice.setCustomerno(res.getInt(3));
				invoices.add(invoice);
			}
			
			return invoices;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void close() {
		DBUtiility.closeConnection(null);
	}

}
