package manytomany;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import utility.HibernateUtility;

public class CriteriaDemoClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Student.class);
		List<Student> students=criteria.list();
		for(Student student:students)
			System.out.println(student.getSname()+" "+student.getMarks());
		
		HibernateUtility.closeSession(null);

	}

}
