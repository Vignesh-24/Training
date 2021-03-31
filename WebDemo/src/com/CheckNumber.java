package com;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CheckNumber extends TagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String number;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter out=pageContext.getOut();
		
		int n=Integer.parseInt(number);
		if(n%2==0) {
			try {
				out.println("<h1>Even Number...</h1>");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				out.println("<h1>Odd Number...</h1>");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return super.doEndTag();
	}
}