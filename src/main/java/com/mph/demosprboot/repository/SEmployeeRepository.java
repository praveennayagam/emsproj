package com.mph.demosprboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mph.demosprboot.entity.SEmployee;

@Repository
public interface SEmployeeRepository extends JpaRepository<SEmployee, Long> {
		public SEmployee findByEname(String name);
}
