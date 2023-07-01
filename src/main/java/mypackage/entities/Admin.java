package mypackage.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private int id;
	
	@Column(name = "admin_username")
	private String username;
	
	@Column(name = "admin_password")
	private String password;
	
	@OneToMany(mappedBy = "admin", fetch = FetchType.EAGER)
	private Set<Subject> subjects = new HashSet<>();
	
	@OneToMany(mappedBy = "admin", fetch = FetchType.EAGER)
	private Set<Clazz> clazzes = new HashSet<>();
	
	@OneToMany(mappedBy = "admin", fetch = FetchType.EAGER)
	private Set<Teacher> teachers = new HashSet<>();	
	
	@OneToMany(mappedBy = "admin", fetch = FetchType.EAGER)
	private Set<Student> students = new HashSet<>();
	
	//Helper Methods
	public void addSubject(Subject subject) {
		subjects.add(subject);
	}
	
	public void addClazz(Clazz clazz) {
		clazzes.add(clazz);
	}
	
	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Clazz> getClazzes() {
		return clazzes;
	}

	public void setClazzes(Set<Clazz> clazzes) {
		this.clazzes = clazzes;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
