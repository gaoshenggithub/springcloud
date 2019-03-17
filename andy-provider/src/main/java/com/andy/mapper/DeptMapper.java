package com.andy.mapper;

import java.util.List;

import com.andy.model.Dept;

public interface DeptMapper {
	public List<Dept> findAll();

	public Dept getIdByDept(Long id);

	public boolean addDept(Dept dept);
}
