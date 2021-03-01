package day7;

public class DecoratorPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IceCream ice=new ChocoChips(new ButterScotch(new Vanila()));
		System.out.println("Cost of Icecream A : "+ice.cost());
		
		IceCream ice_1=new DryFruit(new ButterScotch());
		System.out.println("Cost of Icecream A : "+ice_1.cost());

	}

}

abstract class IceCream{
	abstract public int cost();
}
abstract class Cream extends IceCream{}
abstract class IceCreamIngredients extends IceCream{}

class Vanila extends Cream{
	IceCream iceCream;
	public Vanila() {
		// TODO Auto-generated constructor stub
	}
	
	public Vanila(IceCream iceCream) {
		this.iceCream=iceCream;
	}
	

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return this.iceCream!=null?15+this.iceCream.cost():15;
	}
	
}

class ButterScotch extends Cream{
	IceCream iceCream;
	public ButterScotch() {
		// TODO Auto-generated constructor stub
	}
	
	public ButterScotch(IceCream iceCream) {
		this.iceCream=iceCream;
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
