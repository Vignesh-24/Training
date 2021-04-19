package hiber;

import java.io.Serializable;

public class Comment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	public Comment(String msg) {
		this.msg=msg;
	}
	

	public final String getMsg() {
		return msg;
	}

	public final void setMsg(String msg) {
		this.msg = msg;
	}
	
}
