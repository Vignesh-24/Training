package springdemo;

import java.util.List;
import java.util.Map;

public class FactoryDemo {
	public static void main(String[] args)throws Exception {
		
	}
}
abstract class Shoe{
	
}
class ShoeBuilder{
	
}
class LeatherShoe extends Shoe{	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "This is leather shoe made by bata...:";
	}	
}
class SportsShoe extends Shoe{
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "This is sports shoe made by lakhani...";
	}
}
interface Manufacturer{
	
}
interface ShoeManufacturer extends Manufacturer{
	public Shoe makeShoe();
}
abstract class ShoeFactory implements ShoeManufacturer{
	private String key;
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
class BataShoeFactory extends ShoeFactory{
	
	public BataShoeFactory() {
		System.out.println("bata shoe factory object created...");
	}
	@Override
	public Shoe makeShoe() {
		return new LeatherShoe();
	}
}
class LakhaniShoeFactory extends ShoeFactory{
	@Override
	public Shoe makeShoe() {
		return new SportsShoe();
	}
}
abstract class Customer{
	private String name;
	public Customer(String name) {
		this.setName(name);
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
}
class ShoeCustomer extends Customer{
	public ShoeCustomer(String name) {
		super(name);
	}
}
interface Seller{
	
}
interface ShoeSeller extends Seller{
	public Shoe sellShoe(Customer customer);
	public void test();

}
abstract class ShoeShop implements ShoeSeller{
	private ShoeFactory factory;

	public final ShoeFactory getFactory() {
		return factory;
	}

	public final void setFactory(ShoeFactory factory) {
		System.out.println("set factory called....:"+factory);
		this.factory = factory;
	}
}

class GokulShoeShop extends ShoeShop{
	

	private String shopname;
	private List<String> helper;
	public Map<String, String> getMapp() {
		return mapp;
	}

	public void setMapp(Map<String, String> mapp) {
		this.mapp = mapp;
	}

	private Map<String, String> mapp;
	
	public GokulShoeShop(String name,List<String> list) {
		this.helper=list;
		this.shopname=name;
	}
	
	public List<String> getHelper() {
		return helper;
	}
	public void setHelper(List<String> helper) {
		this.helper = helper;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public GokulShoeShop() {
		System.out.println("gokul shoe shop created...............");
	}
	
	public void setup() {
		System.out.println("Setup Called..");
	}
	
	
	@Override
	public Shoe sellShoe(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Shoe bought by...:"+customer.getName());
		return getFactory().makeShoe();
	}
	
	public void teardown() {
		System.out.println("Destroy Called..");
	}

	@Override
	public void test() {
		System.out.println("test called..");
		
	}

}

