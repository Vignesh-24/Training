package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Myservice {
	@Autowired
	private MyData dao;
	
	public void doService() {
		System.out.println("do service called......");
		dao.doDao();
	}

	public MyData getDao() {
		return dao;
	}

	public void setDao(MyData dao) {
		this.dao = dao;
	}

}


