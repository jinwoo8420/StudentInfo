package com.callor.student.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentVO {
	private int stNum;
	private String name;
	private String dept;
	private int grade;
	private String tel;

	@Override
	public String toString() {
		return "학번 : " + stNum + ", 이름 : " + name + ", 학과 : " + dept + ", 학년 : " + grade + ", 전화번호 : " + tel;
	}

}
