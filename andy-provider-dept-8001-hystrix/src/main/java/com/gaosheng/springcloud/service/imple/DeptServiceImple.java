package com.gaosheng.springcloud.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.model.Dept;
import com.gaosheng.springcloud.dao.DeptDao;
import com.gaosheng.springcloud.service.DeptService;

@Service
public class DeptServiceImple implements DeptService{
	@Autowired
	private DeptDao deptDao;
	@Override
	public List<Dept> list() {
		List<Dept> depts = deptDao.findAll();
		return depts;
	}
	@Override
	public Dept get(String id) {
		Dept dept = deptDao.getIdByDept(id);
		return dept;
	}
	@Override
	public boolean add(Dept dept) {
		boolean add = deptDao.addDept(dept);
		return add;
	}

}
