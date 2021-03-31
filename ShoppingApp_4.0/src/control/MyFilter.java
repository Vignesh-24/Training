package control;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("*.do")
public class MyFilter implements Filter {


	public void destroy() {
		System.out.println("filter destroy called...");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("do filter method called....");
		HttpServletRequest hrequest=(HttpServletRequest)request;
		HttpServletResponse hresponse=(HttpServletResponse)response;
		HttpSession session=hrequest.getSession();
		if(session.isNew()) {
			String id=request.getParameter("formid");
			if(id.equals("lang")) {
				chain.doFilter(request, response);
			}else {
				hresponse.sendRedirect("expiry.jsp");
			}
		}
		else {
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter init called...");
	}

}
