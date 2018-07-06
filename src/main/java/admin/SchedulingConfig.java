package admin;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Title: SchedulingConfig.java
 * @Package admin
 * @Description: TODO(SpringBoot���ö�ʱ�������ֱ��ʹ���Դ���Scheduled�����൱��һ����������Quartz��������������ֱ��ʹ��ע������ɶ�ʱ��������á�)
 * @author FayQ
 * @date 2018��7��6��
 * @version V1.0
 * @email 1010046660@qq.com
 */
@Configuration
@EnableScheduling
@Slf4j
public class SchedulingConfig {

	/**
	 * @Scheduledע�ⶨ���˼ƻ������ִ�мƻ�,�����ַ�ʽ���Զ��壺
	 * 1.@Scheduled(fixedRate = 5000) //ͨ��@Scheduled�����÷����Ǽƻ�����ʹ��fixedRate����ÿ���̶�ʱ��5��ִ��һ�� 
	 * 2.@Scheduled(cron = ��0 0/10 * * * ?��) //ʹ��cron���Կɰ���ָ��ʱ��ִ�У�����ָ����ÿ10����ִ��һ�Σ�
	 */
	@Scheduled(fixedRate=10000)
	public void test() {
		log.info("ִ�ж�ʱ�����");
	}
}
