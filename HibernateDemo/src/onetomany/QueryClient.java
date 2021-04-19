package onetomany;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import utility.HibernateUtility;

public class QueryClient {

	public static void main(String[] args) {
		
		QueryClient qClient=new QueryClient();
		
		//qClient.query1();
		//qClient.query2();
		//qClient.query3();
		//qClient.query4();
		//qClient.query5();
		//qClient.query6();
		//qClient.query7();
		qClient.query8();
		
		HibernateUtility.closeSession(null);
	}
	
	public void query1() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("from Employee");
		List<Employee> list=query.list();
		for(Employee emp:list) {
			System.out.println(emp.getEmpname()+":"+emp.getEmpage());
			Set<Address> addresses=emp.getAddresses();
			for(Address add:addresses) {
				System.out.println(add.getCity()+":"+add.getStreet());
			}
		}		
	}
	
	public void query2() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("from Employee emp where emp.empage>=20");
		List<Employee> list=query.list();
		for(Employee emp:list) {
			System.out.println(emp.getEmpname());
			Set<Address> addresses=emp.getAddresses();
			for(Address add:addresses) {
				System.out.println(add.getCity()+":"+add.getStreet());
			}
		}	
	}
	
	public void query3() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("select emp.empname from Employee emp where emp.empage>=20");
		List<Object> list=query.list();
		for(Object emp:list) {
			System.out.println((String)emp);
		}
		
		Query query2=session.createQuery("select emp.empname,emp.empage from Employee emp where emp.empage>=20");
		List<Object[]> list2=query2.list();
		for(Object[] emp:list2) {
			System.out.println((String)emp[0]+":"+(Integer)emp[1]);
		}
	}
	
	public void query4() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery
				("select e.empname, a.city from Employee e, Address a where a.city=:c");
			query.setParameter("c", "chennai");
			Iterator<Object[]> obj=query.iterate();
			while(obj.hasNext())
			{
				Object o[]=obj.next();
				System.out.println(o[0]+":"+o[1]);
			}
	}
	
	public void query5() {
		//an inner join will return a employee name ONLY if their at least one matching address
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery
				("select e.empname, a.city from Employee e join e.addresses a with a.city=:c");
		query.setParameter("c", "chennai");
		Iterator<Object[]> obj=query.iterate();
		while(obj.hasNext())
		{
			Object o[]=obj.next();
			System.out.println(o[0]+":"+o[1]);
		}
		
	}
	
	public void query6() {
		//an outer join will return all employee names once with a NULL address if no
		//matching employees are found.
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery
				("select e.empname, a.city from Employee e left join e.addresses a with a.city=:c");
		query.setParameter("c", "chennaii");
		Iterator<Object[]> obj=query.iterate();
		while(obj.hasNext())
		{
			Object o[]=obj.next();
			System.out.println(o[0]+":"+o[1]);
		}	
	}
	
	public void query7()
	{
		Session session=HibernateUtility.getSession();
		Query q=session.createQuery("update Employee set empage=empage+100");
		int updateditems=q.executeUpdate();
		System.out.println("No of records updated...:"+updateditems);
		session.beginTransaction().commit();
	}
	
	public void query8()
	{	
		Session session=HibernateUtility.getSession();
		Query q=session.createQuery
		("insert into BackupEmployee (eid, ename,eage) select e.eid,e.empname,e.empage from Employee e");
		int createobjects=q.executeUpdate();
		System.out.println(createobjects);
		session.beginTransaction().commit();
	}

}
