package day7;

public class AdapterPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IndianSocket ss=new ShakthiSocket();
		AmericanPlug ap=new LenovoPlug();
		IndianAdapter ip=new IndianAdapter(ap);
		ss.roundPinHole(ip);

	}

}


abstract class IndianPlug{
	public abstract void roundPin();
}
abstract class IndianSocket{
	public abstract void roundPinHole(IndianPlug ip);
}
abstract class AmericanPlug{
	public abstract void slabPin();
}
abstract class AmericanSocket{
	public abstract void slabPinHole(AmericanPlug ap);
}
class ShakthiSocket extends IndianSocket{
	@Override
	public void roundPinHole(IndianPlug ip) {
		ip.roundPin();
	}
}
class LenovoPlug extends AmericanPlug{
	@Override
	public void slabPin() {
		System.out.println("slab pin working.....");
	}
}

class IndianAdapter extends IndianPlug{
	AmericanPlug ap;
	public IndianAdapter(AmericanPlug ap) {
		this.ap=ap;
	}
	@Override
	public void roundPin() {
		ap.slabPin();
	}
}