package people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

 /*   @Bean
    public CurieProvider curieProvider() {
        return new DefaultCurieProvider("todo",
                new UriTemplate("http://localhost:8080/list/{ref}"));
    }*/

}
