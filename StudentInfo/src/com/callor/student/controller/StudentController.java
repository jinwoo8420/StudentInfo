package com.callor.student.controller;

import java.io.IOException;

import com.callor.student.service.impl.StudentServiceImpl;

public class StudentController {

	public static void main(String[] args) throws IOException {
		StudentServiceImpl stService = new StudentServiceImpl();

		stService.loadStudent();
		stService.inputStudent();
		stService.saveStudent(null);
		stService.printStudent();
	}

}
