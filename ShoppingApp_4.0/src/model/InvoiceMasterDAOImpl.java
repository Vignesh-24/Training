package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;


public class InvoiceMasterDAOImpl implements InvoiceMasterDAO,Cloneable{

	private Properties prop;
	private static InvoiceMasterDAOImpl invoiceMasterDAOImpl;
	
	
	
	private InvoiceMasterDAOImpl(Properties prop) {
		this.prop=prop;
	}
	
	
	public synchronized static InvoiceMasterDAOImpl getInvoiceMasterImpl(Properties prop) {
		if(invoiceMasterDAOImpl==null) {
			invoiceMasterDAOImpl=new InvoiceMasterDAOImpl(prop);
			return invoiceMasterDAOImpl;
		}
		else
			return invoiceMasterDAOImpl.createClone();
		
	}
	
	public InvoiceMasterDAOImpl createClone() {
		try {
			return (InvoiceMasterDAOImpl)super.clone();
		}catch(Exception e) {
			return null;
		}
	}
	
	
	@Override
	public int insertInvoice(InvoiceMasterDTO invMasterDTO) {
		int row=-1;
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("Insert into invoicemaster values(null,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setDate(1, invMasterDTO.getInvdate());
			stmt.setInt(2, invMasterDTO.getCustomerno());
			stmt.execute();
			ResultSet resultSet=stmt.getGeneratedKeys();
			if(resultSet.next()) {
				row=resultSet.getInt(1);
			}
			DBUtility.closeConnection(null);
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return row;
		}
		return row;
	}

	@Override
	public int deleteInvoice(int invno) {
		
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("Delete from invoicemaster where invno=?");
			stmt.setInt(1, invno);
			stmt.execute();
			DBUtility.closeConnection(null);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
		
	}

	@Override
	public int updateInvoice(InvoiceMasterDTO invMasterDTO) {
		
		try {
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("Update invoicemaster	set invdate=?,customerno=? where invno=?");
			stmt.setDate(1, invMasterDTO.getInvdate());
			stmt.setInt(2, invMasterDTO.getCustomerno());
			stmt.setInt(3, invMasterDTO.getInvno());
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
	public InvoiceMasterDTO getInvoiceMaster(int invo) {
		
		try {
			Connection con=DBUtility.getConnection(prop);
			InvoiceMasterDTO invoice=new InvoiceMasterDTO();
			PreparedStatement stmt=con.prepareStatement("select * from invoicemaster where invno=?");
			stmt.setInt(1, invo);
			ResultSet res=stmt.executeQuery();
			
			while(res.next()) {
				invoice.setInvno(res.getInt(1));
				invoice.setInvdate(res.getDate(2));
				invoice.setCustomerno(res.getInt(3));
			}
			DBUtility.closeConnection(null);
			return invoice;
			
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
		
		
	}

	@Override
	public Set<InvoiceMasterDTO> getInvoiceMasterAll() {
		
		try {
			Connection con=DBUtility.getConnection(prop);
			Set<InvoiceMasterDTO> invoices=new HashSet<>();
			PreparedStatement stmt=con.prepareStatement("select * from invoicemaster");
			ResultSet res=stmt.executeQuery();
			
			while(res.next()) {
				InvoiceMasterDTO invoice=new InvoiceMasterDTO();
				invoice.setInvno(res.getInt(1));
				invoice.setInvdate(res.getDate(2));
				invoice.setCustomerno(res.getInt(3));
				invoices.add(invoice);
			}
			DBUtility.closeConnection(null);
			return invoices;
			
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
		
	}


	@Override
	public Set<InvoiceWrapperDTO> getInvoiceDetails(int invno) {
		try {
			Set<InvoiceWrapperDTO> invoice_data=new HashSet<>();
			Connection con=DBUtility.getConnection(prop);
			PreparedStatement stmt=con.prepareStatement("select * from itemmaster i join itemtransaction it on i.itemno=it.itemno where it.invno=?");
			ResultSet resultSet=stmt.executeQuery();
			while(resultSet.next()) {
				InvoiceWrapperDTO dto=new InvoiceWrapperDTO();
				dto.setItem(new ItemMasterDTO(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getFloat(3), 
						resultSet.getInt(4),resultSet.getString(5), 
						resultSet.getString(6)));
				dto.setQuantity(resultSet.getInt(9));
				invoice_data.add(dto);
			}
			
			DBUtility.closeConnection(null);
			return invoice_data;
		}catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
			return null;
		}

	}
	
}
