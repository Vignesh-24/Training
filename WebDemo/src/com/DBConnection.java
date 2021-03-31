package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private PreparedStatement st;
	
	@Override
		public void init(ServletConfig config) throws ServletException {
		
		try {
			super.init(config);
			Enumeration<String> e=config.getInitParameterNames();
			while(e.hasMoreElements()) {
				String name=e.nextElement();
				String value1=config.getInitParameter(name);
				System.out.println(name+":"+value1);
			}
			
			System.out.println(config.getInitParameter("driver")+" "+config.getInitParameter("url")+config.getInitParameter("user")+
					config.getInitParameter("password"));
			Class.forName(config.getInitParameter("driver"));
			con=DriverManager.getConnection(config.getInitParameter("url"),
					config.getInitParameter("user"),
					config.getInitParameter("password"));
			st=con.prepareStatement("Insert into emp values(?,?)");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String s1 = req.getParameter("name");
        String s2 = req.getParameter("age"); 
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<H1> Inserting Record:  </H1>");
        int x = Integer.parseInt(s2);
        try {
            st.setString(1,s1);
            st.setInt(2,x);
            st.executeUpdate();
           }catch(Exception e) { }
        
          pw.println("<h2> BYE  </h2>");
        
	}
	
	
	@Override
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
       
    
}
