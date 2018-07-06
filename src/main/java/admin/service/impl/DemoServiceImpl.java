package admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin.dao.IUserRepository;
import admin.entities.User;
import admin.service.DemoService;

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
