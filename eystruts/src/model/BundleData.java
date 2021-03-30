package model;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class BundleData extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		HttpSession session=pageContext.getSession();
		ResourceBundle rb=(ResourceBundle)session.getAttribute("rb");
		String value=rb.getString(key);
		JspWriter out=pageContext.getOut();
		try {
			out.println(value);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return super.doEndTag();
	}
	

}
