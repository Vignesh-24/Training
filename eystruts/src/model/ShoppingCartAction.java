package model;

import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ShopService;
import service.ShopServiceImpl;
import utility.parser.InvoiceWrapper;

public class ShoppingCartAction extends Action{
	
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	
	HttpSession session=request.getSession();
	@SuppressWarnings("unchecked")
	Map<Integer, Integer>map=(Map<Integer,Integer>)session.getAttribute("selected");
	String []names=request.getParameterValues("selecteditems");
	for(String name: names) 
		map.put(Integer.parseInt(name), Integer.parseInt(request.getParameter(name)));
	ShopService shop=ShopServiceImpl.getShopService((Properties)request.getServletContext().getAttribute("properties"));
	
	InvoiceWrapper invoice_data=shop.buy((String)session.getAttribute("uname"),map);
	session.setAttribute("invoice", invoice_data);
	System.out.println(invoice_data.getItemlist().toString());
	session.removeAttribute("map");
	return "shop.success";
}
}
