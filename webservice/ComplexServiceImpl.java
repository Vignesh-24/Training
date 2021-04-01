package webservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "webservice.ComplexService")
@HandlerChain(file = "webservice/handler-chain.xml")
public class ComplexServiceImpl implements ComplexService{
	
	Employee emp;
	List<Employee> list=new ArrayList<>();
	
	public ComplexServiceImpl() {
		emp=new Employee(1,"vicky",1000);
		list.add(emp);
		emp=new Employee(2,"lulu",2000);
		list.add(emp);
	}
	
	@WebMethod
	@Override
	public Employee getEmployee(String eid) {
		Iterator<Employee> iter=list.iterator();
		int eidnum=Integer.parseInt(eid);
		while(iter.hasNext()) {
			Employee e=iter.next();
			if(e.getEid()==eidnum) 
				return e;
		}
		return null;
	}
	
	@WebMethod
	@Override
	public List<Employee> getAllEmployees() {
		return this.list;
	}
	
	@WebMethod
	@Override
	public void setEmployee(Employee emp) {
		System.out.println("new employee added...:"+emp.getEid()+":"+emp.getEname());
		this.emp=emp;
		list.add(emp);
	}
	
	@WebMethod
	@Override
	public void setAllEmployee(List<Employee> list) {
		System.out.println("all employees are added...."+list);
		this.list=list;
	}
	
	

}
