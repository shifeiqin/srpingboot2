package admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import admin.entities.User;
import admin.service.DemoService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="/demo")
@Slf4j
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	@GetMapping("/test")
	public String test() {
		log.info(this.getClass().getName()+"demo:test");
		return demoService.test();
	}
	@GetMapping("/get/{id}")
	@ResponseBody
	public User get(@PathVariable("id") Integer id) {
		log.info(this.getClass().getName()+"		demo:get		"+id);
		User user = demoService.getOne(id);
		return user;
	}
}
