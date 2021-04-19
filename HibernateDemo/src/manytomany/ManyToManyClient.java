package manytomany;



import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import utility.HibernateUtility;

public class ManyToManyClient {

	public static void main(String[] args) {
		
		Session session=HibernateUtility.getSession();
		Student student=new Student();
		student.setSname("Vignesh");
		student.setMarks(100);
		
		Training training1=new Training();
		training1.setTname("Java");
		training1.setTstartdate(LocalDate.now().plusDays(5));
		
		Training training2=new Training();
		training2.setTname("Python");
		training2.setTstartdate(LocalDate.now().plusDays(10));
		
		Set<Training> trainings=new HashSet<>();
		trainings.add(training1);
		trainings.add(training2);
		
		student.setTrainings(trainings);
		session.save(student);
		
		
		HibernateUtility.closeSession(null);

	}

}
