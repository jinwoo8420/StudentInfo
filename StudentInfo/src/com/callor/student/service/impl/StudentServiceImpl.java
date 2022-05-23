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
import com.callor.utils.Line;

public class StudentServiceImpl implements StudentService {
	private final Scanner sc;
	private final List<StudentVO> sVO;

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

			System.out.print("이름 입력>> ");
			String name = sc.nextLine();

			System.out.print("학과 입력>> ");
			String dept = sc.nextLine();

			System.out.print("학년 입력>> ");
			String stGrade = sc.nextLine();
//			Integer intGrade = Integer.valueOf(stGrade);

			System.out.print("전화번호 입력>> ");
			String tel = sc.nextLine();

			vo.setStNum(stNum);
			vo.setName(name);
			vo.setDept(dept);
			vo.setGrade(stGrade);
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

		out.printf("%s:", sVO.get(sVO.size()-1).getStNum());
		out.printf("%s:", sVO.get(sVO.size()-1).getName());
		out.printf("%s:", sVO.get(sVO.size()-1).getDept());
		out.printf("%s:", sVO.get(sVO.size()-1).getGrade());
		out.printf("%s\n", sVO.get(sVO.size()-1).getTel());

//		for (StudentVO vo : sVO) {
//			out.printf("%s:", vo.getStNum());
//			out.printf("%s:", vo.getName());
//			out.printf("%s:", vo.getDept());
//			out.printf("%s:", vo.getGrade());
//			out.printf("%s\n", vo.getTel());
//		}

		out.flush();
		out.close();
		writer.close();
	}

	@Override
	public void loadStudent() throws IOException {
		String fileName = "src/com/callor/student/model/Studentlist.txt";

		InputStream is = new FileInputStream(fileName);
		Scanner scan = new Scanner(is);

		while (scan.hasNext()) {
			String line = scan.nextLine();

			String[] studentInfo = line.split(":");

			String stNum = studentInfo[0];
			String name = studentInfo[1];
			String dept = studentInfo[2];
			String grade = studentInfo[3];
			String tel = studentInfo[4];

			StudentVO tVO = StudentVO.builder().stNum(stNum).name(name).dept(dept).grade(grade).tel(tel).build();

			sVO.add(tVO);
		}

		scan.close();
		is.close();

	}

	@Override
	public void printStudent() {
		System.out.println(Line.dLine(100));
		System.out.println("학번\t이름\t학과\t학년\t전화번호");
		System.out.println(Line.sLine(100));

		for (int i = 0; i < sVO.size(); i++) {
			System.out.println(sVO.get(i));
		}

		System.out.println(Line.dLine(100));
	}

}
