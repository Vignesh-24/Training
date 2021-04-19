package annopack;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Client {

	public static void main(String[] args) {
		
		SessionFactory factory =new AnnotationConfiguration().configure("hibernate.anno.cfg.xml").buildSessionFactory();
			
			Session session=factory.openSession();
			Transaction tx=session.beginTransaction();
			
			Employee employee1 = new Employee();
			employee1.setId(200);
			employee1.setName("Vignesh K G");
			
			employee1.setJoiningDate(LocalDate.now());
			employee1.setJoiningTime(LocalTime.now());
			employee1.setJoiningDateTime(LocalDateTime.now());
			employee1.setSalary(new BigDecimal(100000));
			employee1.setSsn("24V");
			
			session.save(employee1);	
			
			
			tx.commit();
		//	
			session.close();

	}

}
