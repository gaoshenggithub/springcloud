package com.gaosheng.springcloud.service;

import java.util.List;

import com.andy.model.Dept;

public interface DeptService {
	public List<Dept> list();
	public Dept get(String id);
	public boolean add(Dept dept);
}
