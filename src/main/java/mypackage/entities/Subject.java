package mypackage.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id")
	private int subject_id;

	@Column(name = "subject_name")
	private String subject_name;

	@Column(name = "subject_level")
	private String subject_level;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "cid")
	private Clazz clazz;

	@ManyToOne(cascade = CascadeType.MERGE)
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
	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public String getSubject_level() {
		return subject_level;
	}

	public void setSubject_level(String subject_level) {
		this.subject_level = subject_level;
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
