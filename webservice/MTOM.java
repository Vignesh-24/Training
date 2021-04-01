package webservice;

import java.awt.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MTOM {
	@WebMethod
	public Image getImage(String name)throws Exception;
	@WebMethod
	public void setImage(Image img,String name);

}
