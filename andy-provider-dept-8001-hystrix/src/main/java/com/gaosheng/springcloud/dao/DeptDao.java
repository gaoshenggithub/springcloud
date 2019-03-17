package com.gaosheng.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.andy.model.Dept;


//@Mapper
public interface DeptDao {
	public List<Dept> findAll();
	public Dept getIdByDept(String id);
	public boolean addDept(Dept dept);
}
