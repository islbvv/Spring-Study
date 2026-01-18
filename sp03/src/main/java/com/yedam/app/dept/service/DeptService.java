package com.yedam.app.dept.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
	// 전체조회
	public List<DeptVO> findDeptAll();

	// 단건조회
	public DeptVO findDept(DeptVO deptVO);

	// 등록
	public int addDept(DeptVO deptVO);

	// 수정
	public Map<String, Object> updateDept(DeptVO deptVO);

	// 삭제
	public Map<String, Object> deleteDept(int deptId);

}
