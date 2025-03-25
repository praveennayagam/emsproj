package com.mph.demosprboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mph.demosprboot.entity.SEmployee;
import com.mph.demosprboot.service.SEmployeeService;

@RestController
@RequestMapping("/demosprboot/api/semployee")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*",allowCredentials = "true")
public class SEmployeeController {
	@Autowired
	SEmployeeService sEmployeeService;
	
	@PostMapping("/addemp")
	public ResponseEntity<?> addEmployee(@RequestBody SEmployee employee) {
		sEmployeeService.createEmployee(employee);
		return new ResponseEntity<>(employee,HttpStatus.CREATED) ;
		
		
	}

	@GetMapping("/listallemp")
	public ResponseEntity<List<SEmployee>>getAllEmployee() {
		System.out.println("hhhhhhiiiii");
		List<SEmployee>emplist =sEmployeeService.getAllEmployee();
		return ResponseEntity.ok(emplist);
	}

	@PutMapping("/updateemp")
	public ResponseEntity<List<SEmployee>> updateEmployee(@RequestBody SEmployee employee) {
		List<SEmployee> updatedemp =sEmployeeService.updateEmployee(employee);
		return ResponseEntity.ok(updatedemp);
	}

	@DeleteMapping("/deletebyid/{eid}")
	public ResponseEntity<List<SEmployee>> deleteEmployee(@PathVariable Long eid) {
	
		List<SEmployee> existingemp =sEmployeeService.deleteEmployee(eid);
		return ResponseEntity.ok(existingemp);
	}

	@GetMapping("/getempbyid/{eid}")
	public ResponseEntity<Optional<SEmployee>> getEmployeeById(@PathVariable Long eid) {
		Optional<SEmployee> emp =sEmployeeService.getEmployeeById(eid);
		return ResponseEntity.ok(emp);
		
	}

	@GetMapping("/findbyname/{name}")
	public ResponseEntity<SEmployee>getEmployeeByEname(@PathVariable String name) {
		SEmployee emp=sEmployeeService.getEmployeeByEname(name);
		return ResponseEntity.ok(emp);
	}
}
