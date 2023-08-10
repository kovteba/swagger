package kovteba.config;

import kovteba.config.source.SwaggerConfig1;
import kovteba.config.source.SwaggerConfig2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Primary
    @Bean
    public SwaggerResourcesProvider configureSwagger(InMemorySwaggerResourcesProvider defaultResourcesProvider) {

        var swaggerConfig = new SwaggerConfig2();
        return swaggerConfig.swaggerResourcesProvider(defaultResourcesProvider);
    }

//    @Bean
//    public Docket configureSwagger() {
//
//        var swaggerConfig = new SwaggerConfig1();
//        return swaggerConfig.apis();
//    }
}
