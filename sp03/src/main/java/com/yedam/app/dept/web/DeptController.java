package com.yedam.app.dept.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DeptController {
	private final DeptService deptService;

	// 전체조회
	@GetMapping("deptList")
	public String DeptList(Model model) {
		List<DeptVO> list = deptService.findDeptAll();
		model.addAttribute("dept", list);
		return "dept/deptAllList";
	}

	// 단건조회
	@GetMapping("deptInfo")
	public String deptInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.findDept(deptVO);
		model.addAttribute("dept", findVO);
		return "dept/deptInfo";
	}

	// 등록
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/deptInsert";
	}

	@PostMapping("deptInsert")
	public String deptInsertProcess(DeptVO deptVO) {
		int deptId = deptService.addDept(deptVO);
		return "redirect:deptInfo?departmentId=" + deptId;
	}

	// 수정
	@GetMapping("deptUpdate")
	public String updateForm(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.findDept(deptVO);
		model.addAttribute("dept", findVO);
		return "dept/deptUpdate";
	}

	@PostMapping("deptUpdate")
	@ResponseBody
	public Map<String, Object> deptUpdateProcess(@RequestBody DeptVO deptVO) {
		return deptService.updateDept(deptVO);
	}

	// 삭제
	@GetMapping("deptDelete")
	public String deptDelete(Integer deptId) {
		deptService.deleteDept(deptId);
		return "redirect:deptList";
	}

}
