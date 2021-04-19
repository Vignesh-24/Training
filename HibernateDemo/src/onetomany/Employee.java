package onetomany;

import java.util.Set;

public class Employee {
	private int eid;
	private String empname;
	private int empsal;
	private int empage;
	private Set<Address> addresses;
	
	public final int getEmpage() {
		return empage;
	}
	public final void setEmpage(int empage) {
		this.empage = empage;
	}
	
	public final int getEid() {
		return eid;
	}
	public final void setEid(int eid) {
		this.eid = eid;
	}
	public final String getEmpname() {
		return empname;
	}
	public final void setEmpname(String empname) {
		this.empname = empname;
	}
	public final int getEmpsal() {
		return empsal;
	}
	public final void setEmpsal(int empsal) {
		this.empsal = empsal;
	}
	public final Set<Address> getAddresses() {
		return addresses;
	}
	public final void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
}
