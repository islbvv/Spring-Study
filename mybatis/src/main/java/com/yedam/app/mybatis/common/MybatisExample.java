package com.yedam.app.mybatis.common;

import java.util.List;

import com.yedam.app.mybatis.mapper.EmpMapper;
import com.yedam.app.mybatis.mapper.EmpMapperImpl;
import com.yedam.app.mybatis.service.EmpVO;

public class MybatisExample {
	private static EmpMapper empMap = new EmpMapperImpl();

	public static void main(String[] args) {
//		selectAll();
//		selectInfo();
//		insertInfo();
//		updateInfo();
		deleteInfo();

	} // main

	public static void selectAll() {
		List<EmpVO> list = empMap.selectAll();
		for (EmpVO emp : list) {
			System.out.println(emp);
		}
	}

	public static void selectInfo() {
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(210);

		EmpVO findVO = empMap.selectInfo(emp);
		System.out.println(findVO);
	}

	public static void insertInfo() {
		EmpVO emp = new EmpVO();
		emp.setLastName("사오리");
		emp.setEmail("saori.com");
		emp.setJobId("IT_PROG");

		int result = empMap.insertInfo(emp);
		System.out.println(result);
	}

	public static void updateInfo() {
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(210);
		emp.setFirstName("조마에");
		emp.setSalary(6000);

		int result = empMap.updateInfo(emp);
		System.out.println(result);
	}

	public static void deleteInfo() {
		int result = empMap.deleteInfo(210);
		System.out.println(result);
	}
} // class
