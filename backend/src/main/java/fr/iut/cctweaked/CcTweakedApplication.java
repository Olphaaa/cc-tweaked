package fr.iut.cctweaked;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CcTweakedApplication {

    public static void main(String[] args) {
        SpringApplication.run(CcTweakedApplication.class, args);
    }

}
