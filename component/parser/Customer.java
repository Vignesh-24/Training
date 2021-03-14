package component.parser;

public class Customer {
	private String name;
	private String billid;
	private String billdate;
	@Override
	public String toString() {
		return "Customer [name=" + name + ", billid=" + billid + ", billdate=" + billdate + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBillid() {
		return billid;
	}
	public void setBillid(String billid) {
		this.billid = billid;
	}
	public String getBilldate() {
		return billdate;
	}
	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}

}
