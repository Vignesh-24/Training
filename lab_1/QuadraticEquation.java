package lab_1;

public class QuadraticEquation {
	
	
	private int a;
	private int b;
	private int c;
	
	public QuadraticEquation() {
		this.a=this.b=this.c=1;
	}
	
	public QuadraticEquation(int a,int b,int c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public void modify(int a,int b,int c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getC() {
		return c;
	}

	
	public long compute(int x) {
		return (this.a*(x*x))+(this.b*x)+this.c;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QuadraticEquation eqn1=new QuadraticEquation();
		eqn1.getA();
		eqn1.getB();
		eqn1.getC();
		eqn1.modify(1, 2, 3);
		System.out.println("Equation 1 Result: "+eqn1.compute(2));
		
		QuadraticEquation eqn2=new QuadraticEquation(2,3,4);
		eqn2.getA();
		eqn2.getB();
		eqn2.getC();
		System.out.println("Equation 2 Result: "+eqn2.compute(2));

	}

}
