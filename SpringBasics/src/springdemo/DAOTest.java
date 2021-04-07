package springdemo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DAOTest {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		DBDAO dao=ctx.getBean("dao", DBDAO.class);
		dao.firstTest();
		dao.secondTest();
		ctx.close();

	}

}
