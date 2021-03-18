package day22;

import java.util.Set;

public interface ItemTransactionDAO {
	
	public int insertNewTransaction(ItemTransactionDTO itm);
	public int deleteTransaction(int invno,int itemno);
	public ItemTransactionDTO getTransaction(int invno,int itemno);
	public int updateTransaction(ItemTransactionDTO itm);
	public Set<ItemTransactionDTO> getAllTransactions();

}
