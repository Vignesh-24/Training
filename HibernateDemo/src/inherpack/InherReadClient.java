package inherpack;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import utility.HibernateUtility;

public class InherReadClient {

	public static void main(String[] args) {
		
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("from ShoeFactory");
		List<ShoeFactory> list=query.list();
		Iterator<ShoeFactory> itr=list.iterator();
		
		while(itr.hasNext()) {
			ShoeFactory factory=itr.next();
			factory.print();
		}
		
		HibernateUtility.closeSession(null);
	}

}
