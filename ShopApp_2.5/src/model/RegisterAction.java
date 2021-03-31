package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginService;
import service.LoginServiceImpl;

public class RegisterAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		
		int flag=Integer.parseInt(request.getParameter("flag"));
		Properties prop=(Properties)request.getServletContext().getAttribute("properties");
		LoginService loginService=LoginServiceImpl.getLoginServiceImpl(prop);
		
		UserDTO user=new UserDTO();
		user.setUname(uname);
		user.setUpass(upass);
		user.setFlag(flag);
		
		if(loginService.registerUser(user)==0) {
			System.out.println("registration failed");
			return "register.failure";
		}
		else {
			return "register.success";
		}
	}

}
