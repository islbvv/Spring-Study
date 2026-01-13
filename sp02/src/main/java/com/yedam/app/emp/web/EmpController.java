package com.yedam.app.emp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // Lombok -> final filed를 활용한 생성자
@Controller // Router
public class EmpController {
	private final EmpService empService;

	@GetMapping("/empList")
	public String empList(Model model) {
		List<EmpVO> list = empService.findAll();
		model.addAttribute("emps", list);
		return "empList";
	}
}
