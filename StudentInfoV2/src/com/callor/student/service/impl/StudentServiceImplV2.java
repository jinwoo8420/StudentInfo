package com.callor.student.service.impl;

import java.io.PrintStream;
import java.util.List;

import com.callor.student.model.StudentVO;
import com.callor.utils.Line;

public class StudentServiceImplV2 extends StudentServiceImpl {
	private final PrintStream ps;

	/*
	 * 매개변수로 stdList와 fileName을 주입받아
	 * V1 클래스의 생성자를 통해서 stdList와 fileName 초기화하기
	 */

	public StudentServiceImplV2(List<StudentVO> stdList, String fileName, PrintStream ps) {
		super(stdList, fileName);
		this.ps = ps;
	}

	@Override
	public void printStudent() {
//		PrintStream ps = System.out;
		printAndFileSavaStudent(ps);
	}

	protected void printAndFileSavaStudent(PrintStream ps) {
		PrintStream out = ps;

		out.println(Line.dLine(50));
		out.println("학생관리");
		out.println(Line.sLine(50));

		out.println("학번\t이름\t학과\t학년\t전화번호");
		out.println(Line.sLine(50));

		for (StudentVO stVO : stdList) {
			out.printf("%s\t", stVO.getNum());
			out.printf("%s\t", stVO.getName());
			out.printf("%s\t", stVO.getDept());
			out.printf("%s\t", stVO.getGrade());
			out.printf("%s\n", stVO.getTel());
		}

		out.close();
		ps.close();
	}

}
