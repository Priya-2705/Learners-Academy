package mypackage.models;

public class TeacherModel {
	
	private String name;
	private String qualification;
	private String cid;
	
	public TeacherModel() {
		// TODO Auto-generated constructor stub
	}

	public TeacherModel(String name, String qualification, String cid) {
		super();
		this.name = name;
		this.qualification = qualification;
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
}
