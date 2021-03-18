package rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import rmiserver.backend.ItemMasterDTO;

public interface Invoice extends Remote {

	void startInvoiceApp() throws RemoteException;
	void createInvoice(int custno,int invno,Map<Integer,Integer> map)throws RemoteException;
	void addItem(ItemMasterDTO item)throws RemoteException;
	void calculateDate()throws RemoteException;
	void createPDF(int invno)throws RemoteException;
	void createExcel(int invno)throws RemoteException;
	void closeApp()throws RemoteException;
}
