package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

// 비즈니스 로직을 가지는 Bean, AOP를 적용
@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {
	private final EmpMapper empMapper;

	// 전체조회
	@Override
	public List<EmpVO> findAll() {
		return empMapper.selectEmpAll();
	}

	// 단건조회
	@Override
	public EmpVO findByEmployeeId(EmpVO empVO) {
		return empMapper.selectEmp(empVO);
	}

	// 등록
	@Override
	public int addEmpInfo(EmpVO empVO) {
		int result = empMapper.insertEmp(empVO);
		return result == 1 ? empVO.getEmployeeId() : -1;
	}

	// 수정
	@Override
	public Map<String, Object> modifyEmpInfo(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;

		int result = empMapper.updateEmp(empVO.getEmployeeId(), empVO);
		if (result == 1) {
			isSuccessed = true;
		}

		map.put("result", isSuccessed);
		map.put("target", empVO);
		/*
		 * { "result": true, "target": { "employeeId: 100, "lastName": "King", ... } }
		 */

		return map;
	}

	// 삭제
	@Override
	public Map<String, Object> removeEmpInfo(int empId) {
		Map<String, Object> map = new HashMap<>();
		int result = empMapper.deleteEmp(empId);
		if (result == 1) {
			map.put("employeeId", empId);
		}
		return map;
	}

}
