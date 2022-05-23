package com.callor.student.service;

import java.io.IOException;

public interface StudentService {
	public void inputStudent();

	public void loadStudent() throws IOException;

	public void saveStudent(String fileName) throws IOException;
	
	public void printStudent();

}
