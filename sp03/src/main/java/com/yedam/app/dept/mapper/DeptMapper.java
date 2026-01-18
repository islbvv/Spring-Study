package com.yedam.app.dept.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.dept.service.DeptVO;

public interface DeptMapper {
	// 전체조회
	public List<DeptVO> findDeptAll();

	// 단건조회
	public DeptVO findDept(DeptVO deptVO);

	// 등록
	public int insertDept(DeptVO deptVO);

	// 수정
	public int updateDept(@Param("deptId") int departmentId, @Param("dept") DeptVO deptVO);

	// 삭제
	public int deleteDept(int departmentId);
}
