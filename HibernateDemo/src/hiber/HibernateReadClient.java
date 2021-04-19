package hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateReadClient {
	public static void main(String[] args) {
				

		Configuration cfg=new Configuration();


		SessionFactory factory=cfg.configure().buildSessionFactory();
		
		Session session=factory.openSession();
		
		
		BookDTO bookObj=(BookDTO)session.get(BookDTO.class, Integer.valueOf(1));
		
        System.out.println(bookObj);
		
		Comment comm=bookObj.getComment();
		
		System.out.println(comm.getMsg());
		
	}
}
