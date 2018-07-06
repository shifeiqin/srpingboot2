package com.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.User;
import com.demo.service.DemoService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Title: CommonController.java
 * @Package com.common.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author FayQ
 * @date 2018年7月6日
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
	
	@GetMapping("/login")
    public String login(@RequestParam(value="name") String name,@RequestParam(value="pwd") String pwd,HttpServletRequest request) {
        HttpSession session = request.getSession();

        if(name.equals("root")&&pwd.equals("root")) {
            User user = new User();
            user.setName(name);
            session.setAttribute("user",user);
            return "登录成功";
        } else {
            return "用户名或密码错误!";
        }
    }
}
