package day6;

import java.util.Scanner;

public class DogDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		NaughtyChild child=new NaughtyChild();
		Scanner scanner=new Scanner(System.in);
		while(true) {
			GoodDog dog=Container.getDog();
			child.playWithDog(dog, scanner.next());
		}

	}

}


abstract class Item{
	public abstract void action();
}

class Stone extends Item{

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("you hit I bark.....");
		
	}
	
}

class Stick extends Item{
	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("you beat I bite......");
		
	}
	
}

class GoodDog{
	Item item;
	public void play(String item) throws Exception {
		this.item=Container.getItem(item);
		this.item.action();
	}
}



class Container{
	public static Item getItem(String item) throws Exception{
		Item itm= (Item) Class.forName("day6."+item).newInstance();
		return itm;
	}
	
	public static GoodDog getDog() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return (GoodDog)Class.forName("day6.GoodDog").newInstance();
	}
}




class NaughtyChild {
	public void playWithDog(GoodDog dog,String item) throws Exception {
		dog.play(item);
	}
}