package day22;



import day21.DBUtiility;

public class Main {

	public static void main(String[] args) {
		 Main main=new Main();
		// main.CustomerTest();
		 main.ItemTest();

	}
	
	
	public void CustomerTest() {
		
		try {
			
			CustomerMasterDAOImpl impl=new CustomerMasterDAOImpl();
			impl.connect();
			System.out.println("Insertion Status: "+impl.insertCustomer(new CustomerMasterDTO(6,"dhoni","mahi@gmail.com","Ranchi",887541234)));
			System.out.println("Deletion Status: "+impl.deleteCustomer(4));
			System.out.println("Update Status: "+impl.updateCustomer(new CustomerMasterDTO(3,"dhoni","mahi@gmail.com","Ranchi,Jharkhand",887541234)));
			System.out.println("Get Customer: "+impl.getCustomer(1));
			System.out.println("All: "+impl.getAllCustomers());
			impl.close();
			
		}catch (Exception e) {
			
			DBUtiility.closeConnection(e);
			
		}
	
	}
	
	
	public void ItemTest() {
		
		try {
			
			ItemMasterDAOImpl impl=new ItemMasterDAOImpl();
			impl.connect();
			System.out.println("Insertion Status: "+impl.insertItem(new ItemMasterDTO(1,"Rice",50,1)));
			System.out.println("Insertion Status: "+impl.insertItem(new ItemMasterDTO(2,"Sugar_new",70,1)));
			System.out.println("Insertion Status: "+impl.insertItem(new ItemMasterDTO(3,"Chocolate",50,1)));
			System.out.println("Deletion Status: "+impl.deleteItem(1));
			System.out.println("All: "+impl.getAllItems());
			System.out.println("Update Status: "+impl.updateItem(new ItemMasterDTO(2,"Sugar",75,1)));
			System.out.println("Get Customer: "+impl.getItem(3));
			System.out.println("All: "+impl.getAllItems());
			impl.close();
			
		} catch (Exception e) {
			DBUtiility.closeConnection(e);
		}
		
	}

}
