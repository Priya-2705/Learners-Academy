package mypackage.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teacher_id")
	private int teacher_id;

	@Column(name = "teacher_name")
	private String teacher_name;

	@Column(name = "teacher_qual")
	private String teacher_qual;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(
	        name = "teacher_class",
	        joinColumns = { @JoinColumn(name = "teacher_id") },
	        inverseJoinColumns = { @JoinColumn(name = "class_id") }
	    )
	private Set<Clazz> clazzes = new HashSet<>();

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "aid", referencedColumnName = "admin_id")
	private Admin admin;

	// Helper Method
	public void addClass(Clazz clazz) {
		clazzes.add(clazz);
	}

	// Getters and Setters
	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_qual() {
		return teacher_qual;
	}

	public void setTeacher_qual(String teacher_qual) {
		this.teacher_qual = teacher_qual;
	}

	public String getClazzes() {
		StringBuffer sb = new StringBuffer();
		if(clazzes != null && clazzes.size()>0)
		{
			for(Clazz c : clazzes)
			{
				sb.append(c.getClazz_name() + ",");
			}
		}
		return sb.toString();

	}

	public void setClazzes(Set<Clazz> clazzes) {
		this.clazzes = clazzes;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}