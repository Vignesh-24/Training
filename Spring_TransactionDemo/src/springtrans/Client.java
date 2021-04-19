package springtrans;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client {
	
	public static void main(String[] args) throws Exception{
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("config3.xml");
		
		BusinessBean bb=ctx.getBean("businessadvisedbean",BusinessBean.class);
		
		bb.doTransaction(2,1,2000);
		
		ctx.close();
	
	}
}
