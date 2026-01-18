package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

// DispacherServlet과 관련이 있음
@Controller
public class EmpController {
	private final EmpService empService;

	// @Autowired
	public EmpController(EmpService empService) {
		this.empService = empService;
	}

	// 스프링은 REST API 기반이 아니므로 2개의 메서드만 사용함
	// GET: 빈페이지, 조회
	// POST: 데이터 조작(등록, 수정, 삭제)

	// 참고
	// Model: Spring에서 Request + Response를 편하게 사용하기 위해 만든 것

	// 로직 순서
	// 1. 제공할 서비스 수행
	// 2. 클라이언트에 전달할 데이터 담기
	// 3. 데이터를 출력할 페이지 선택
	// -> 페이지 이름은 "/"로 시작하면 안 됨
	// -> prefix + 페이지 + suffix로 구성이 됨
	// prefix -> classpath:/templates/
	// suffix -> .html

	// 전체조회
	@GetMapping("empList")
	public String EmpList(Model model) {
		List<EmpVO> list = empService.findAll();
		model.addAttribute("emps", list);
		return "emp/list";
	}

	// 단건조회
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.findByEmployeeId(empVO);
		model.addAttribute("emp", findVO);
		return "emp/info";
	}

	// 등록 - 페이지
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}

	// 등록 - 처리
	// <form /> -> QueryString
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.addEmpInfo(empVO);
		return "redirect:empInfo?employeeId=" + eid;
	}

	// 수정 - 페이지: 단건조회랑 유사함
	@GetMapping("empUpdate")
	public String updateFrom(EmpVO empVO, Model model) {
		EmpVO findVO = empService.findByEmployeeId(empVO);
		model.addAttribute("emp", findVO);
		return "emp/update";
	}

	// 수정 - 처리
	@PostMapping("empUpdate")
	@ResponseBody
	public Map<String, Object> empUpdateProcess(@RequestBody EmpVO empVO) {
		return empService.modifyEmpInfo(empVO);
	}

	// 삭제
	@GetMapping("empDelete")
	public String empDelete(Integer empId) {
		empService.removeEmpInfo(empId);
		return "redirect:empList";
	}

}
