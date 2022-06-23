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
    public static final String SUPPLIER_TAG = "Supplier endpoints";
    public static final String STORAGE_TAG = "Storage endpoints";
    public static final String SITE_TAG = "Site endpoints";
    public static final String USER_TAG = "User endpoints";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("fr.iut.cctweaked"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(SUPPLIER_TAG, "Supplier endpoints documentation"))
                .tags(new Tag(STORAGE_TAG, "Storage endpoints documentation"))
                .tags(new Tag(SITE_TAG, "Site endpoints documentation"))
                .tags(new Tag(USER_TAG, "User endpoints documentation"));
    }
}
