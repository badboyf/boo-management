import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/*
 * @Title : Application.java
 * 
 * @version V1.0
 * @date：2017年8月23日
 * @Copyright © 2016 江苏华叶跨域教育科技发展股份有限公司 Corporation. All rights reserved. 
 */

/**
 * @ClassName: Application
 * @Description:
 * @author Wangjing
 * @date 2017年8月23日
 * 
 */
@EnableEurekaServer
@SpringBootApplication
@ComponentScan("com.book")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
