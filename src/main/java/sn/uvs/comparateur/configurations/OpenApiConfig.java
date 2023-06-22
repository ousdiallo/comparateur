package sn.uvs.comparateur.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI productsOpenAPI(){
        return new OpenAPI()
                .info(new Info().title("API REST Comparateur de prix Sénégal")
                        .description("Cette API REST  est développée dans le cadre de la mise en place " +
                                "d'un comparateur de prix au Sénégal. " )
                        .version("1.0"));
    }
}


