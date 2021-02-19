package lab_1;

public class AccessTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccessHelper access=new AccessHelper();
		System.out.println("Default "+access.deff);
		System.out.println("Protected "+access.protect);
		/*System.out.println("Private "+access.pvt); Private not accessible*/
		System.out.println("Public "+access.pub);
	    access.publicTest();
	    access.protectedTest();
	    access.defaultMethod();
	    /* access.privateTest();  Not accessible*/

	}

}

class AccessHelper{
	
	int deff=1;
	@SuppressWarnings("unused")
	private int pvt=2;
	protected int protect=3;
	public int pub=4;
	
	public void publicTest() {
		System.out.println("Public Method Called");
	}
	
	@SuppressWarnings("unused")
	private void privateTest() {
		System.out.println("Private Method Called");
	}
	
	protected void protectedTest() {
		System.out.println("Protected Method Called");
	}
	
	void defaultMethod() {
		System.out.println("Default Method Called");
	}
}
