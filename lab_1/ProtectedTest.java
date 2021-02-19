package lab_1;

public class ProtectedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProtectedUser user=new ProtectedUser();
		user.useProtectedData();
 
	}

}


class ProtectedHelper{
	protected int data=50;
	protected String str="This is Protected";
}

class ProtectedUser{
	public void useProtectedData() {
		ProtectedHelper help=new ProtectedHelper();
		System.out.println(help.str+" "+help.data);
		
	}
}