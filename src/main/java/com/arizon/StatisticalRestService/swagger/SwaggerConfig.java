package com.arizon.StatisticalRestService.swagger;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact("Erik Svensson", "instagram.com/arizon_dread", "arizon.es@gmail.com");

//    public static final ApiInfo DEFAULT_APIINFO = new ApiInfo("StatisticalRestService",
//                    "With this application, it is possible to persist data related to measurements, " +
//                    "such as temperature, weight etc.", "1.0", "Data persistance after deal with server admin, " +
//                    "code is OpenSource. If used, please give back to the community in some way", DEFAULT_CONTACT,
//                    "GPL", "https://www.gnu.org/licenses/gpl.html" new Collection<VendorExtension>())

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.arizon.StatisticalRestService.controller")).build()
                .apiInfo(apiInfo())
                .tags(  new Tag("GetData","Use to get data from database"),
                        new Tag("GetVersion", "Use to get version of application"),
                        new Tag("SaveCaller", "Create a new client instance" +
                                " and register what kind of data it will persist."),
                        new Tag("SaveData", "Persist data to the database."));

    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("StatisticalRestService").version("1.0.0").build();
    }
}
