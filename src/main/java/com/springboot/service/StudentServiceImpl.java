package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.entity.Student;
import com.springboot.repository.StudentRepository;

@Component
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student findStudentById(int id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		Student updateStudent = studentRepository.findById(student.getId()).orElse(null);
		updateStudent.setContact(student.getContact());
		updateStudent.setDepartment(student.getDepartment());
		updateStudent.setName(student.getName());
		updateStudent.setPercentage(student.getPercentage());
		updateStudent.setPrn(student.getPrn());
		updateStudent.setUniversity(student.getUniversity());
		return studentRepository.save(updateStudent);
	}

	@Override
	public String deleteById(int id) {
		studentRepository.deleteById(id);
		return "Student Deleted Successfully....!!";
	}

	@Override
	public List<Student> addStudent(List<Student> students) {
		return (List<Student>) studentRepository.saveAll(students);
	}

	@Override
	public List<Student> readAll() {
		return (List<Student>) studentRepository.findAll();
	}

}
