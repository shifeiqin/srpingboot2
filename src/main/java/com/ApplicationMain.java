package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
/**
 * 
 * @Title: ApplicationMain.java
 * @Package admin
 * @Description: TODO(Spring Boot����ע�⣬���ڿ����Զ�����)
 * @author FayQ
 * @date 2018��7��6��
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
