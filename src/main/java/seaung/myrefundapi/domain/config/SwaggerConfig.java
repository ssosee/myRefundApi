package seaung.myrefundapi.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

/**
 * <a href = "https://www.youtube.com/watch?v=Q27PGBYmHNA">์ฐธ๊ณ </a>
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("seaung.myrefundapi"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("๐ฐํ๊ธ์ก ์กฐํ ์๋น์ค API")
                .description("์๋ํ์ธ์!๐\n" +
                        "ํ๊ธ์ก ์กฐํ ์๋น์ค ์๋๋ค." +
                        "์์ธํ ์ฌํญ์ https://github.com/ssosee/myRefundApi ๋ฅผ ์ฐธ๊ณ ํด์ฃผ์ธ์.")
                .version("1.0.0")
                .build();
    }
}
