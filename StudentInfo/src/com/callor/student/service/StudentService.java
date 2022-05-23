package com.callor.student.service;

import java.io.IOException;

public interface StudentService {
	public void inputStudent();

	public void printStudent() throws IOException;

	public void saveStudent(String fileName) throws IOException;

}
