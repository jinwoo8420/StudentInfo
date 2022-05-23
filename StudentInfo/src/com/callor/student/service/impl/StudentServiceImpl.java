package com.callor.student.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.student.model.StudentVO;
import com.callor.student.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private Scanner sc;
	private List<StudentVO> sVO;

	public StudentServiceImpl() {
		sc = new Scanner(System.in);
		sVO = new ArrayList<>();
	}

	@Override
	public void inputStudent() {
		while (true) {
			StudentVO vo = new StudentVO();

			System.out.print("학번 입력(QUIT : 종료)>> ");
			String stNum = sc.nextLine();

			if (stNum.equals("QUIT")) {
				break;
			}

			Integer intNum = Integer.valueOf(stNum);

			System.out.print("이름 입력>> ");
			String name = sc.nextLine();

			System.out.print("학과 입력>> ");
			String dept = sc.nextLine();

			System.out.print("학년 입력>> ");
			String stGrade = sc.nextLine();
			Integer intGrade = Integer.valueOf(stGrade);

			System.out.print("전화번호 입력>> ");
			String tel = sc.nextLine();

			vo.setStNum(intNum);
			vo.setName(name);
			vo.setDept(dept);
			vo.setGrade(intGrade);
			vo.setTel(tel);

			sVO.add(vo);
		}

	}

	@Override
	public void saveStudent(String fileName) throws IOException {
		File file = new File("src/com/callor/student/model/Studentlist.txt");

		FileWriter writer = null;
		PrintWriter out = null;

		writer = new FileWriter(file, true);
		out = new PrintWriter(writer);

		for (StudentVO vo : sVO) {
			out.printf("%s:", vo.getStNum());
			out.printf("%s:", vo.getName());
			out.printf("%s:", vo.getDept());
			out.printf("%s:", vo.getGrade());
			out.printf("%s\n", vo.getTel());
		}

		out.flush();
		out.close();
		writer.close();
	}

	@Override
	public void printStudent() throws IOException {
		String fileName = "src/com/callor/student/model/Studentlist.txt";

		InputStream is = new FileInputStream(fileName);
		Scanner scan = new Scanner(is);

		while (scan.hasNext()) {
			String line = scan.nextLine();
			System.out.println(line);
		}

		scan.close();
		is.close();
	}

}
