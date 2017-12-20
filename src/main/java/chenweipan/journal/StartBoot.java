package chenweipan.journal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties()
public class StartBoot {
    public static void main(String[] args) throws ParseException {
        SpringApplication.run(StartBoot.class, args);
    }
}
