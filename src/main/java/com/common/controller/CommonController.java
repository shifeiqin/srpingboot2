package com.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.User;
import com.demo.service.DemoService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Title: CommonController.java
 * @Package com.common.controller
 * @Description: TODO(��һ�仰�������ļ���ʲô)
 * @author FayQ
 * @date 2018��7��6��
 * @version V1.0
 * @email 1010046660@qq.com
 */
@RestController
@RequestMapping(value="/common")
@Slf4j
public class CommonController {

	@Autowired
	private DemoService demoService;
	
	@GetMapping("/test")
	public String test() {
		log.info(this.getClass().getName()+"demo:test");
		return demoService.test();
	}
}
