package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
/**
 * 
 * @Title: ApplicationMain.java
 * @Package admin
 * @Description: TODO(Spring Boot核心注解，用于开启自动配置)
 * @author FayQ
 * @date 2018年7月6日
 * @version V1.0
 * @email 1010046660@qq.com
 */
@SpringBootApplication 
@ServletComponentScan
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}
