package com.callor.student.controller;

import com.callor.student.service.StudentService;
import com.callor.student.service.impl.StudentServiceImpl;

public class StudentController {

	public static void main(String[] args) {
		/*
		 * stService 객체를 생성하는 순간
		 * student.txt 파일에서 데이터를 읽어
		 * stdList가 준비된다
		 */
		StudentService stService = new StudentServiceImpl();
		stService.printStudent();

	}

}
