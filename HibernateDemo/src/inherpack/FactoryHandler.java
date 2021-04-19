package inherpack;

public class FactoryHandler {
	
	public void handle(ShoeFactory factory) {
		System.out.println(factory.getName());
	}
	
	public void handle(BataShoeFactory factory) {
		System.out.println(factory.getBataName());
	}
	
	public void handle(LakhaniShoeFactory factory) {
		System.out.println(factory.getLakhaniName());
	}

}
