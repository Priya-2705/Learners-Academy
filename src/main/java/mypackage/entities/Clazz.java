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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Clazz")
public class Clazz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clazz_id")
	private int clazz_id;

	@Column(name = "clazz_name")
	private String clazz_name;

	@OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL)
	private Set<Subject> subjects = new HashSet<>();

	@ManyToMany(mappedBy = "clazzes")
	private Set<Teacher> teachers = new HashSet<>();

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "aid")
	private Admin admin;
	
	@OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL)
	private Set<Student> students = new HashSet<>();

	// Helper Methods
	public void addStudent(Student student) {
	    this.students.add(student);
	}

	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}

	public void addTeacher(Teacher teacher) {
		this.teachers.add(teacher);
	}

	// Getters and Setters
	public int getClazz_id() {
		return clazz_id;
	}

	public void setClazz_id(int clazz_id) {
		this.clazz_id = clazz_id;
	}

	public String getClazz_name() {
		return clazz_name;
	}

	public void setClazz_name(String clazz_name) {
		this.clazz_name = clazz_name;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
}
