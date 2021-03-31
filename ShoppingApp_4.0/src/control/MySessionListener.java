package control;

import java.util.Properties;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import service.LoginService;
import service.LoginServiceImpl;

@WebListener
public class MySessionListener implements HttpSessionListener {

  
    public void sessionCreated(HttpSessionEvent se)  { 
        System.out.println("session created called.....:"+se.getSession());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	HttpSession session=se.getSession();
    	Properties prop=(Properties)session.getServletContext().getAttribute("properties");
    	LoginService loginService=LoginServiceImpl.getLoginServiceImpl(prop);
    	String uname=(String)session.getAttribute("uname");
    	if(uname!=null) {
    		loginService.updateFlag(uname, 0);
    	}
        System.out.println("session destroyed called...:");
    }
	
}
