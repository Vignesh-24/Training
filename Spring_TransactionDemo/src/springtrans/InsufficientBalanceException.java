package springtrans;

public class InsufficientBalanceException extends  Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	public InsufficientBalanceException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return this.msg;
	}
}
