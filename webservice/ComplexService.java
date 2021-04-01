package webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ComplexService {
	
	@WebMethod
	public Employee getEmployee(String eid);
	@WebMethod
	public List<Employee> getAllEmployees();
	@WebMethod
	public void setAllEmployee(List<Employee> list);
	@WebMethod
	public void setEmployee(Employee emp);
	
	

}
