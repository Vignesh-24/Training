package webservice;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "webservice.MTOM")
@HandlerChain(file = "handler-chain.xml")
public class MTOMImpl implements MTOM{
	
	@WebMethod
	@Override
	public Image getImage(String name)throws Exception {
		File f=new File(name);
		return ImageIO.read(f);
	}
	
	@WebMethod
	@Override
	public void setImage(Image img,String name) {
		try{
			File fos=new File(name);
			BufferedImage bimage=(BufferedImage)img;
			ImageIO.write(bimage,"jpg", fos);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	

}
