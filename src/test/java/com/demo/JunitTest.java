package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.service.DemoService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitTest {

	@Autowired
	private DemoService demoService;
	
	@Test
	public void test() {
		String test = demoService.test();
		System.out.println(test);
	}
}
