package mypackage.models;

public class SubjectModel {
	
	private String name;
	private String level;
	private String cid;
	
	public SubjectModel() {
		// TODO Auto-generated constructor stub
	}

	public SubjectModel(String name, String level, String cid) {
		super();
		this.name = name;
		this.level = level;
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
}
