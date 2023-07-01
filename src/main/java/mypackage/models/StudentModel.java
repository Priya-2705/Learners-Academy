package mypackage.models;

public class StudentModel {
	
	private String name;
	private String address;
	private String cid;
	
	public StudentModel() {
		// TODO Auto-generated constructor stub
	}

	public StudentModel(String name, String address, String cid) {
		super();
		this.name = name;
		this.address = address;
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}	
}
