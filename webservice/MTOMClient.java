package webservice;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class MTOMClient {

	public static void main(String[] args) throws Exception {
		
		URL url =new URL("http://localhost:3000/ws/hello?wsdl");
		QName qname =new QName("http://webservice/","MTOMImplService");
		Service service = Service.create(url, qname);
		MTOM mtom=service.getPort(MTOM.class);
		
		//Sending image
		BindingProvider bp = (BindingProvider) mtom;
		SOAPBinding binding = (SOAPBinding) bp.getBinding();
		binding.setMTOMEnabled(true);
		Image img=ImageIO.read(new File("first.jpg"));
		mtom.setImage(img,"cricketbat.jpg");
		
		
		//reading Image
		
		img= mtom.getImage("cricketbat.jpg");
		JFrame frame =new JFrame();
		frame.setSize(300, 300);
		JLabel label =new JLabel(new ImageIcon(img));
		frame.add(label);
		frame.setVisible(true);
	}

}
