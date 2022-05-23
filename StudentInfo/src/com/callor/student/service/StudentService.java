package com.callor.student.service;

import java.io.IOException;

public interface StudentService {
	public void inputStudent() throws IOException;

	public void loadStudent() throws IOException;

	public void saveStudent(String fileName) throws IOException;
	
	public void printStudent();

}
