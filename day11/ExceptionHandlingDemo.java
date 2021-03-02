package day11;

import java.util.Scanner;

public class ExceptionHandlingDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Dog dog=Dog.getDog();
		Child child=Child.getChild();
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		Item item=(Item)Class.forName(name).getConstructor().newInstance();
		child.playWithDog(dog, item);
		
		
		Dog dog2=dog.getDogClone();
		Child child2=child.getChildClone();
		name=sc.next();
		item=(Item)Class.forName(name).getConstructor().newInstance();
		child2.playWithDog(dog2, item);

	}

}




class Dog implements Cloneable{
	private static Dog dog;
	private Dog() {
		System.out.println("Dog Object Created");
	}
	
	public Dog getDogClone() throws CloneNotSupportedException {
		System.out.println("Cloned Dog Object....");
		return (Dog)super.clone();
	}
	
	public static Dog getDog() {
		if(dog==null)
			dog=new Dog();
		return dog;
		
	}
	public void play(Item item) throws DogException{
		item.execute();
		
	}
}

interface Item{
	public abstract void execute() throws DogException;
}

class Child implements Cloneable{
	
	private static Child child;
	private Child() {
		System.out.println("Child Object Created..");
	}
	public Child getChildClone() throws CloneNotSupportedException {
		System.out.println("Cloned Child Object....");
		return (Child)super.clone();
	}
	
	public static Child getChild() {
		if(child==null)
			child=new Child();
		return child;
		
	}

	
	public void playWithDog(Dog dog,Item item) {
		
		try {
			dog.play(item);
			
		}catch(DogException de) {
			System.out.println(de);
			de.visit();
		}
		
	}
	
}

abstract class DogException extends Exception{
	public abstract void visit();
	
}


class DogBiteException extends DogException{
	String msg;
	

	@Override
	public String toString() {
		return msg;
	}


	public DogBiteException(String msg) {
		this.msg = msg;
	}


	@Override
	public void visit() {
		// TODO Auto-generated method stub
		HandlerDogImpl.getExceptionHandler().handle(this);
		
	}
	
	


}

class DogBarkException extends DogException{
	String msg;
	
	@Override
	public String toString() {
		return msg;
	}

	public DogBarkException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public void visit() {
		HandlerDogImpl.getExceptionHandler().handle(this);
		
	}
	
	
	


}


class DogHappyException extends DogException{
	
	String msg;
	
	public DogHappyException(String msg) {
		super();
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return msg;
	}

	@Override
	public void visit() {
		// TODO Auto-generated method stub
		HandlerDogImpl.getExceptionHandler().handle(this);
		
	}
	
}



class BiscuitItem implements Item{
	
	public BiscuitItem() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute() throws DogException {
		// TODO Auto-generated method stub
		throw new DogHappyException("Yummy...Biscuitt!!");
		
	}
	
}

class StoneItem implements Item{
	
	public StoneItem() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() throws DogException {
		throw new DogBarkException("Stone....Barking...!");
		
	}
	
}


class StickItem implements Item{
	
	public StickItem() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() throws DogException {
		throw new DogBiteException("Stick..Biteee!!");
		
	}
}

interface HandlerDog{
	public abstract void handle(DogBiteException de);
	public abstract void handle(DogBarkException dbe);
	public abstract void handle(DogHappyException dh);
}


class HandlerDogImpl implements HandlerDog{
	
	private static HandlerDogImpl handler;
	
	private HandlerDogImpl() {
		System.out.println("Singleton Object of HandlerDogImpl Created..!");
	}
	
	public static HandlerDogImpl getExceptionHandler() {
		if(handler==null)
			handler=new HandlerDogImpl();
		return handler;
		
	}

	@Override
	public void handle(DogBarkException de) {
		System.out.println("Dont worry...! Wont Bite");
		
	}

	@Override
	public void handle(DogBiteException dbe) {
		System.out.println("Taking to the Hospital..");
		
	}

	@Override
	public void handle(DogHappyException dh) {
		// TODO Auto-generated method stub
		System.out.println("Dog is Happyyyy...");
		
	}
	
}
