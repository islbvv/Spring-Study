package com.yedam.app.dept.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService {
	private final DeptMapper deptMapper;

	// 전체조회
	@Override
	public List<DeptVO> findDeptAll() {
		return deptMapper.findDeptAll();
	}

	// 단건조회
	@Override
	public DeptVO findDept(DeptVO deptVO) {
		return deptMapper.findDept(deptVO);
	}

	// 등록
	@Override
	public int addDept(DeptVO deptVO) {
		int result = deptMapper.insertDept(deptVO);
		return result == 1 ? deptVO.getDepartmentId() : -1;
	}

	// 수정
	@Override
	public Map<String, Object> updateDept(DeptVO deptVO) {
		Map<String, Object> map = new HashMap<>();
		int result = deptMapper.updateDept(deptVO.getDepartmentId(), deptVO);
		boolean isSuccessed = result == 1 ? true : false;
		map.put("result", isSuccessed);
		map.put("target", deptVO);
		return map;
	}

	// 삭제
	@Override
	public Map<String, Object> deleteDept(int deptId) {
		Map<String, Object> map = new HashMap<>();
		int result = deptMapper.deleteDept(deptId);
		boolean isSuccessed = result == 1 ? true : false;
		map.put("result", isSuccessed);
		return map;
	}

}
