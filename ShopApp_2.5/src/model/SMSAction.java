package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ShopService;
import service.ShopServiceImpl;

public class SMSAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Properties prop=(Properties)request.getServletContext().getAttribute("properties");
		ShopService shp=ShopServiceImpl.getShopService(prop);
		int invno=Integer.parseInt(request.getParameter("invno"));
		shp.sendMsg(invno);
		return "sms.success";
	}

}
