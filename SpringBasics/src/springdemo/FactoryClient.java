package springdemo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class FactoryClient {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		//new FileSystemXmlApplicationContext();
		
		
		ShoeSeller seller=ctx.getBean("advisedShop",ShoeSeller.class);
		
		Customer customer=new ShoeCustomer("vicky");
		
		
		Shoe shoe=seller.sellShoe(customer);
		
		//seller.sellShoe(customer);
		
		System.out.println(shoe);
		seller.test();
		Export export=(Export)seller;
		
		export.doExport();
		/*GokulShoeShop seller=ctx.getBean("shop",GokulShoeShop.class);
		Customer customer=new ShoeCustomer("vicky");
		Shoe shoe=seller.sellShoe(customer);
		System.out.println(shoe);
		System.out.println(seller.getShopname());
		System.out.println(seller.getHelper());
		System.out.println(seller.getMapp());*/
		ctx.close();
	}
}
