package admin;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Title: SchedulingConfig.java
 * @Package admin
 * @Description: TODO(SpringBoot配置定时任务可以直接使用自带的Scheduled，这相当于一个轻量级的Quartz，它可以让我们直接使用注解来完成定时任务的配置。)
 * @author FayQ
 * @date 2018年7月6日
 * @version V1.0
 * @email 1010046660@qq.com
 */
@Configuration
@EnableScheduling
@Slf4j
public class SchedulingConfig {

	/**
	 * @Scheduled注解定义了计划任务的执行计划,有两种方式可以定义：
	 * 1.@Scheduled(fixedRate = 5000) //通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间5秒执行一次 
	 * 2.@Scheduled(cron = “0 0/10 * * * ?”) //使用cron属性可按照指定时间执行，本例指的是每10分钟执行一次；
	 */
	@Scheduled(fixedRate=10000)
	public void test() {
		log.info("执行定时任务吧");
	}
}
