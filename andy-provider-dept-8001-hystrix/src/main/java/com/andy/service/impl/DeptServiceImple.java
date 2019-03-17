package com.andy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.mapper.DeptMapper;
import com.andy.model.Dept;
import com.andy.service.DeptService;

@Service
public class DeptServiceImple implements DeptService {
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public List<Dept> list() {
		List<Dept> depts = deptMapper.findAll();
		return depts;
	}

	@Override
	public Dept get(Long id) {
		Dept dept = deptMapper.getIdByDept(id);
		return dept;
	}

	@Override
	public boolean add(Dept dept) {
		boolean add = deptMapper.addDept(dept);
		return add;
	}

}
