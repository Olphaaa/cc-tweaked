package fr.iut.cctweaked.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
    public static final String SUPPLIER_TAG = "Supplier endpoints documentation";
    //todo add the user part (the tag (here) and the @Api in the userController class)
    // todo and this for all controllers
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("fr.iut.cctweaked"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(SUPPLIER_TAG, "Supplier endpoints documentation"));
    }
}
