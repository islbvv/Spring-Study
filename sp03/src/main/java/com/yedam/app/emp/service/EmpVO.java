package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
// @AllArgsConstructor와 @Data가 있어야 @Builder 사용가능
@AllArgsConstructor
@Data
@Builder
public class EmpVO {
	private Integer employeeId; // PK
	private String firstName;
	private String lastName; // NOT Null
	private String email; // NOT Null, uk
	private String phoneNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate; // NOT Null
	private String jobId; // NOT Null, FK
	private double salary;
	private double commissionPct;
	private int managerId; // FK
	private int departmentId; // FK
}
