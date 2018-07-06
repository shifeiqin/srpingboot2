package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IUserRepository;
import com.demo.entities.User;
import com.demo.service.DemoService;


@Service
public class DemoServiceImpl implements DemoService{

	@Autowired
	private IUserRepository dao;
	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "hi test!";
	}

	@Override
	public User getOne(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOne(id);
	}

}
