package project;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import project.aspect.NotNullByDefault;

import javax.annotation.Nullable;

/**
 * Created by klok on 10.5.18.
 */
@NotNullByDefault
@SpringBootApplication
public class LogisticApplication {

    public static void main(@Nullable String[] args) {
        //SpringApplication.run(LogisticApplication.class, args);
        new SpringApplicationBuilder(LogisticApplication.class).web(true).run(args);
    }
}
