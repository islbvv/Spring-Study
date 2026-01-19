package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptVO;

@SpringBootTest
public class HomeTest {

	@Autowired
	private DeptMapper deptMapper;

	@Test
	public void contextLoadsTest() {
		assertNotNull(deptMapper);
	}

	@Test
	public void findDeptAll() {
		List<DeptVO> list = deptMapper.findDeptAll();
		assertFalse(list.isEmpty());
		System.out.println();
		for (DeptVO dept : list) {
			System.out.println("[findDeptAll] " + dept);
		}
		System.out.println();
	}

//	@Test
	public void findDept() {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(301);

		DeptVO findVO = deptMapper.findDept(deptVO);
		assertEquals("ST-Curriculum", findVO.getDepartmentName());
		System.out.println();
		System.out.println("[findDept] " + findVO);
		System.out.println();
	}

//	@Test
	public void insertDept() {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentName("사오리");

		int result = deptMapper.insertDept(deptVO);
		assertEquals(1, result);
		System.out.println();
		System.out.println("[insertDept] Success");
		System.out.println();
	}

//	@Test
	public void updateDept() {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentName("Saori");
		deptVO.setManagerId(1002);
		deptVO.setLocationId(1002);

		int result = deptMapper.updateDept(302, deptVO);
		assertEquals(1, result);
		System.out.println(deptVO.toString());
		System.out.println();
		System.out.println("[updateDept] Success");
		System.out.println();
	}

//	@Test
	public void deleteDept() {
		int result = deptMapper.deleteDept(302);
		assertEquals(1, result);
		System.out.println();
		System.out.println("[deleteDept] Success");
		System.out.println();
	}
}
