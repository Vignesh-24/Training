package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ShopService;
import service.ShopServiceImpl;

public class ShoppingAction extends Action{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Properties prop=(Properties)request.getServletContext().getAttribute("properties");
		ShopService shop=ShopServiceImpl.getShopService(prop);
		String category=request.getParameter("next");
		HttpSession session=request.getSession();
		String []names=request.getParameterValues("selecteditems");
		if(session.getAttribute("selected")==null)
			session.setAttribute("selected", new HashMap<Integer,Integer>());
		if(names!=null) {
			@SuppressWarnings("unchecked")
			Map<Integer, Integer>map=(Map<Integer,Integer>)session.getAttribute("selected");
			for(String name: names) 
				map.put(Integer.parseInt(name), Integer.parseInt(request.getParameter(name)));
			session.setAttribute("selected", map);
			System.out.println(map.toString());
		}
		Set<ItemMasterDTO> items=shop.loadByCategory(category);
		session.setAttribute("items", items);
		return category;
	}
}
