package onetomany;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import utility.HibernateUtility;

public class CriteriaQueryClient {

	public static void main(String[] args) {
		
		CriteriaQueryClient qClient=new CriteriaQueryClient();
		
//		qClient.query1();
//		qClient.query11();
//		qClient.query2();
//		qClient.query3();
//		qClient.query4();
//		qClient.query5();
//		qClient.query6();
//		qClient.query7();
		qClient.query8();
		
		HibernateUtility.closeSession(null);
				
	}
	
	public static void display(Criteria criteria)
	{
		List<Employee> employees=criteria.list();
		Iterator<Employee> iter=employees.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next().getEmpname());
		}
	}
	
	public void query1() {
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Employee.class);
		display(criteria);
	}
	
	public void query11()
	{
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.addOrder(Order.desc("empname"));
		display(criteria);
	}
	
	public void query2()
	{
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Employee.class);
		//criteria.add(Restrictions.eq("name", "ramu"));
		//or
		criteria.add(Property.forName("emp.empname").eq("vicky"));
		Employee emp=(Employee)criteria.uniqueResult();
		System.out.println(emp.getEmpname());
	}
	
	public void query3()
	{
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Address.class);
		//criteria.add(Restrictions.eq("emp.empname", "vicky"));
		//or
		criteria.add(Property.forName("emp.empname").eq("ramu"));
		List<Address> addresses=criteria.list();
		Iterator<Address> iter=addresses.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next().getCity());
		}
	}
	
	public void query4()
	{
		Session session=HibernateUtility.getSession();
		//int f[]={new Integer(20),new Integer(40)};
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.add(Restrictions.between("empage",new Integer(20),new Integer(40)));
		//or
		//criteria.add(Property.forName("empage").in(f));
		display(criteria);
	}
	
	public void query5()
	{
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.add(Restrictions.like("empname", "V%").ignoreCase());
		display(criteria);	
	}
	
	public void query6()
	{
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.
			add(Restrictions.like("empname", "V%").ignoreCase())
			.add(Restrictions.gt("empage", new Integer(20)));
		display(criteria);
	}
	
	public void query7()
	{
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.add(
				Restrictions.or(Restrictions.like("empname", "V%")
						.ignoreCase(),
				Restrictions.gt("empage", new Integer(20))));
				display(criteria);
	}
	
	public void query8()
	{
		Session session=HibernateUtility.getSession();
		DetachedCriteria dc=DetachedCriteria.forClass(Employee.class);
		dc.add(
				Restrictions.or(Restrictions.like("empname", "s%"),
				Restrictions.gt("empage", new Integer(20)))
			);
		Criteria criteria=dc.getExecutableCriteria(session);
		display(criteria);
	}

}
