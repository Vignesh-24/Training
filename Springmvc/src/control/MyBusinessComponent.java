package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBusinessComponent {
	
	@Autowired
	private Myservice service;

	public Myservice getService() {
		return service;
	}

	public void setService(Myservice service) {
		this.service = service;
	}
	
	public Employee doBusiness() {
		System.out.println("do business called...................");
		service.doService();
		return new Employee();
	}

}


class Employee{

	@Override
	public String toString() {
		return "Employee Vignesh K G";
	}
	
}