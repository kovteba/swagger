package kovteba.config.source;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;

import static springfox.documentation.builders.PathSelectors.regex;

public class SwaggerConfig1 {

    public Docket apis() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().paths(getPaths()::test).build();
    }

    private Predicate<String> getPaths() {

        Predicate<String> path = (paths) -> paths.matches("/user.*");

        return path.or(p -> p.matches("/admin.*"));

    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder().title("Swagger API")
                                   .description("Swagger API documentation")
                                   .termsOfServiceUrl("https://www.linkedin.com/in/dmytro-kovteba-8b759283/")
                                   .licenseUrl("kovteba@gmail.com")
                                   .version("1.0")
                                   .build();
    }
}
