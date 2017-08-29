import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

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
@SpringBootApplication
@ComponentScan("com.book")
@EnableMongoRepositories("com.book")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
