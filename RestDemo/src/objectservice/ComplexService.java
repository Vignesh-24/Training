package objectservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("empservice")
public class ComplexService {
	
	Employee emp;
	List<Employee> list=new ArrayList<>();
	
	
	public ComplexService() {
		emp=new Employee(1,"vicky",1000);
		this.list.add(emp);
		emp=new Employee(2,"lulu",2000);
		this.list.add(emp);
	}
	
	
	@POST
	@Path("setemp")
	@Consumes("application/json")
	public void setEmployee(Employee emp) {
		this.emp=emp;
		System.out.println(list.size());
		this.list.add(this.emp);
		System.out.println(list.size());
	}
	
	
	
	@GET
	@Path("getemp/{eid}")
	//@Produces("application/xml")
	@Produces("application/json")
	public Employee getEmployee(@PathParam("eid") String eid) {
		Iterator<Employee> iter=this.list.iterator();
		int eidnum=Integer.parseInt(eid);
		
		while(iter.hasNext()) {
			Employee e=iter.next();
			System.out.println(e);
			if(e.getEid()==eidnum) {
				return e;
			}
		}
		return null;
	}
	
	
	
	@GET
	@Path("getall")
	@Produces("application/json")
	public List<Employee> getAllEmployees(){
		return this.list;
	}
	
	
	
}



