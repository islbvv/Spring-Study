package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

// @Controller + @ResponseBody
@RestController
@RequiredArgsConstructor
public class EmpRestController {

	private final EmpService empService;

	// 전체조회
	@GetMapping("emps")
	public List<EmpVO> empList() {
		return empService.findAll();
	}

	// 단건조회
	@GetMapping("emps/{eid}")
	public EmpVO empInfo(@PathVariable Integer eid) {
		EmpVO empVO = EmpVO.builder().employeeId(eid).build();
		return empService.findByEmployeeId(empVO);
	}

	// 등록
	@PostMapping("emps")
	public Integer empInsert(@RequestBody EmpVO empVO) {
		return empService.addEmpInfo(empVO);
	}

	// 수정
	@PutMapping("emps/{eid}")
	public Map<String, Object> empUpdate(@PathVariable(name = "eid") Integer empolyeeId, @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(empolyeeId);
		return empService.modifyEmpInfo(empVO);
	}

	// 삭제
	@DeleteMapping("emps/{employeeId}")
	public Map<String, Object> empDelete(@PathVariable Integer employeeId) {
		return empService.removeEmpInfo(employeeId);
	}

}
