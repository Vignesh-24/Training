package day10;

public class DecoratorCloning {

	public static void main(String[] args) throws CloneNotSupportedException{
		// TODO Auto-generated method stub

		Vanila vanila=Vanila.createObject();
		ButterScotch butter=ButterScotch.createObject();
		IceCream vanila1=vanila.getVanilawithOtherClone(butter.getButterScotchClone());
		IceCream butter1=new ChocoChips(vanila.getVanilaCone());
		System.out.println("Ice 1: "+vanila1.cost());
		System.out.println("Ice 2: "+butter1.cost());

	}

}


abstract class IceCream{
	abstract public int cost();
}
abstract class Cream extends IceCream{}
abstract class IceCreamIngredients extends IceCream{}

class Vanila extends Cream implements Cloneable{
	IceCream iceCream;
	private static Vanila vanila;
	
	
	private Vanila() {
		// TODO Auto-generated constructor stub
	}
	
	private Vanila(IceCream iceCream) {
		this.iceCream=iceCream;
	}
	
	public static Vanila createObject() {
		return vanila==null?new Vanila():vanila;
		
	}
	
	public static Vanila createObject(IceCream icecream) {
		return vanila==null?new Vanila(icecream):vanila;
		
	}
	
		

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return this.iceCream!=null?15+this.iceCream.cost():15;
	}
	
	public Vanila getVanilaCone() throws CloneNotSupportedException{
		return (Vanila)super.clone();
	}
	
	public Vanila getVanilawithOtherClone(IceCream icecream) throws CloneNotSupportedException{
		this.iceCream=icecream;
		return (Vanila)super.clone();
	}
	
}

class ButterScotch extends Cream implements Cloneable{
	IceCream iceCream;
	static ButterScotch butterscotch;
	private ButterScotch() {
		// TODO Auto-generated constructor stub
	}
	
	private ButterScotch(IceCream iceCream) {
		this.iceCream=iceCream;
	}
	
	public static ButterScotch createObject() {
		return butterscotch==null?new ButterScotch():butterscotch;
	}
	
	public static ButterScotch createObject(IceCream icecream) {
		return butterscotch==null?new ButterScotch(icecream):butterscotch;
	}
	
	
	public ButterScotch getButterScotchClone() throws CloneNotSupportedException {
		return (ButterScotch)super.clone();
	}
	
	public ButterScotch getButterScotchWithOtherClone(IceCream icecream) throws CloneNotSupportedException {
		this.iceCream=icecream;
		return (ButterScotch)super.clone();
	}
	
	

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return this.iceCream!=null?25+this.iceCream.cost():25;
	}
	
	
}

class DryFruit extends IceCreamIngredients{
	
	IceCream iceCream;
	
	public DryFruit(IceCream iceCream) {
		this.iceCream = iceCream;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return this.iceCream!=null?5+this.iceCream.cost():5;
	}
	
}

class ChocoChips extends IceCreamIngredients{
	
	IceCream iceCream;
	
	public ChocoChips(IceCream iceCream) {
		this.iceCream = iceCream;
	}


	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return this.iceCream!=null?15+this.iceCream.cost():15;
	}
	
}