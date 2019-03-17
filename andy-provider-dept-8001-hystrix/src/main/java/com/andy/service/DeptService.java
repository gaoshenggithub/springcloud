package com.andy.service;

import java.util.List;

import com.andy.model.Dept;

public interface DeptService {
	public List<Dept> list();

	public Dept get(Long id);

	public boolean add(Dept dept);
}
