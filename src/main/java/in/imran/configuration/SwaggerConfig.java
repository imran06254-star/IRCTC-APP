package in.imran.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI swaggerApi(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("IRCTC Management API")
                                .version("1.0")
                                .description("Rest API for IRCTC Management")
                );

    }
}
