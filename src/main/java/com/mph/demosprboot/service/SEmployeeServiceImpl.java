package com.mph.demosprboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mph.demosprboot.entity.SEmployee;
import com.mph.demosprboot.repository.SEmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SEmployeeServiceImpl implements SEmployeeService{
	@Autowired
	SEmployeeRepository sEmployeeRepository;
	@Override
	public void createEmployee(SEmployee employee) {
		sEmployeeRepository.save(employee);
		
	}

	@Override
	public List<SEmployee> getAllEmployee() {
		
		return sEmployeeRepository.findAll();
	}

	@Override
	public List<SEmployee> updateEmployee(SEmployee employee) {
		sEmployeeRepository.save(employee);
		return getAllEmployee();
	}

	@Override
	public List<SEmployee> deleteEmployee(Long eid) {
		sEmployeeRepository.deleteById(eid);
		return getAllEmployee();
	}

	@Override
	public Optional<SEmployee> getEmployeeById(Long eid) {
		Optional<SEmployee> emp=sEmployeeRepository.findById(eid);
		return emp;
	}

	@Override
	public SEmployee getEmployeeByEname(String name) {
		SEmployee emp=sEmployeeRepository.findByEname(name);
		return emp;
	}
	
}
