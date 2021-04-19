package onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import utility.HibernateUtility;

public class OneToManyClient {
	public static void main(String[] args) {
		Session session=HibernateUtility.getSession();
		
		Employee emp=new Employee();
		emp.setEmpname("Sai");
		emp.setEmpsal(250000);
		emp.setEmpage(22);
		Address add1=new Address();
		add1.setCity("chennai");
		add1.setStreet("B street");
		
		Address add2=new Address();
		add2.setCity("mumbai");
		add2.setStreet("A street.");
		
		Set<Address> addresses=new HashSet<Address>();
		addresses.add(add1);
		addresses.add(add2);
		
		emp.setAddresses(addresses);
		
		session.save(emp);
		
		
		HibernateUtility.closeSession(null);
		
	}
}
