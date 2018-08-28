package spring.ex06.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class School {
	
	@Autowired
	private Teacher teacher;
	@Autowired
	private Student student;	
	@Autowired
	private Teacher adminTeacher;
	
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getAdminTeacher() {
		return adminTeacher;
	}

	public void setAdminTeacher(Teacher adminTeacher) {
		this.adminTeacher = adminTeacher;
	}

	@Override
	public String toString() {
		return "School [teacher=" + teacher + ", student=" + student + ", adminTeacher=" + adminTeacher + "]";
	}
	
	
}
