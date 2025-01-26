package backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = "backend")
@EnableAspectJAutoProxy
@MapperScan("backend.mapper")
public class MeetingForYouApplication{

    public static void main(String[] args) {
        SpringApplication.run(MeetingForYouApplication.class, args);
    }
}
