package com.yedam.app.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

// @Service
// 비즈니스 로직에 해당하는 객체
// AOP를 적용하는 객체
@Service
public class EmpServiceImpl implements EmpService {

	private EmpMapper empMapper;

	public EmpServiceImpl() {
	}

	// DI(생성자 주입)
	// 생성자가 하나일 경우 무조건 DI가 되므로 @Autowired를 생략해도 됨
	@Autowired
	public EmpServiceImpl(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}

	@Override
	public List<EmpVO> findAll() {
		return empMapper.selectAll();
	}

}
