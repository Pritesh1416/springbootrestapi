package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Student;
import com.springboot.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@GetMapping("/read/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Student getStudent(@PathVariable int id) {
		return studentService.findStudentById(id);
	}

	@PutMapping("/update")
	@ResponseStatus(code = HttpStatus.UPGRADE_REQUIRED)
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteById(id);
	}
	@PostMapping("/createAll")
	public List<Student> createAllStudents(@RequestBody List<Student> students) {
		return studentService.addStudent(students);
	}
	@GetMapping("/readAll")
	public List<Student> getAll() {
		return studentService.readAll();
	}
}
