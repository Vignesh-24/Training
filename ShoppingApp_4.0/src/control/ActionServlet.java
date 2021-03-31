package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ActionServlet",urlPatterns = {"*.do"},initParams = {
		@WebInitParam(name="config",value = "/WEB-INF/config.properties"),
		@WebInitParam(name="dbconfig",value = "/WEB-INF/dbconfig.properties")
})
public class ActionServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RequestProcessor rp;Properties prop;
	@Override
		public void init(ServletConfig config) throws ServletException {
		try {
			String file=config.getInitParameter("config");
			System.out.println(file);
			String dbfile=config.getInitParameter("dbconfig");
			System.out.println(dbfile);
			String path=config.getServletContext().getRealPath(file);
			String dbpath=config.getServletContext().getRealPath(dbfile);
			config.getServletContext().setAttribute("path", path);
			prop=new Properties();
			prop.load(new FileInputStream(dbpath));
			Class.forName(prop.getProperty("driver"));
			config.getServletContext().setAttribute("properties", prop);
			this.rp=new RequestProcessor();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.rp.process(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
