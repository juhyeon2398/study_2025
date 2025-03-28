package org.joonzis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // 생성자
@AllArgsConstructor // 풀생성자
@Getter 
@Setter
public class StudentDto {
	private String name,dept;
	private int gradeNo, classNo;
}