package kovteba.config.source;

import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import java.util.ArrayList;
import java.util.List;

public class SwaggerConfig2 {

    public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider) {

        return () -> {
            List<SwaggerResource> resources = new ArrayList<>();
            resources.add(loadResource("/api-documentation/swagger-config.yml"));// custom
            resources.add(loadResource("/v2/api-docs"));// default
            return resources;
        };
    }

    private SwaggerResource loadResource(String resource) {

        SwaggerResource wsResource = new SwaggerResource();
        wsResource.setName(resource);
        wsResource.setSwaggerVersion("2.0");
        wsResource.setLocation(resource);

        return wsResource;
    }
}
