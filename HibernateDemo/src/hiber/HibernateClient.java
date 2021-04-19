package hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateClient {
	public static void main(String[] args) {
		BookDTO bookDto=new BookDTO(1,"java","james",340);
		
		Comment comment=new Comment();
		comment.setMsg("this is comment value.................");
		
		bookDto.setComment(comment);
	
		Configuration cfg=new Configuration();

		SessionFactory factory=cfg.configure().buildSessionFactory();
		
		Session session=factory.openSession();
		
		session.save(bookDto);
		
		session.beginTransaction().commit();
		
		
		
	}
}
