package mypackage.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int student_id;

	@Column(name = "student_name")
	private String student_name;

	@Column(name = "student_address")
	private String address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cid")
	private Clazz clazz;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "aid")
	private Admin admin;
	
	// Helper Method
	public String getClazzName() {
	    if (clazz != null) {
	        return clazz.getClazz_name();
	    }
	    return "";
	}

	// Getters and Setters
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Clazz getClazz() {
	    return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
