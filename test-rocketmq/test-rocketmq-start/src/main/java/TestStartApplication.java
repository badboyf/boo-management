
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.book.rocketmq.annotation.EnableRocketMQ;

@SpringBootApplication
@ComponentScan("com.book")
@EnableRocketMQ(packages = "com.book")
public class TestStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestStartApplication.class, args);
	}

}
