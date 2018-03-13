package ru.bellintegrator.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import ru.bellintegrator.practice.countries.controller.CountryControllerImpl;
import ru.bellintegrator.practice.documents.controller.DocTypeControllerImpl;
import ru.bellintegrator.practice.countries.dao.CountryDaoImpl;
import ru.bellintegrator.practice.documents.dao.DocTypeDaoImpl;
import ru.bellintegrator.practice.countries.service.CountryServiceImpl;
import ru.bellintegrator.practice.documents.service.DocTypeServiceImpl;
import ru.bellintegrator.practice.office.controller.OfficeControllerImpl;
import ru.bellintegrator.practice.office.dao.OfficeDaoImpl;
import ru.bellintegrator.practice.office.service.OfficeServiceImpl;
import ru.bellintegrator.practice.organization.controller.OrganizationControllerImpl;
import ru.bellintegrator.practice.organization.dao.OrganizationDaoImpl;
import ru.bellintegrator.practice.organization.service.OrganizationServiceImpl;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Locale;

@EnableSwagger2
@ImportResource("spring_mvc_config.xml")
@SpringBootApplication
@ComponentScan(basePackageClasses = {
        DocTypeControllerImpl.class, DocTypeServiceImpl.class, DocTypeDaoImpl.class,
        CountryControllerImpl.class, CountryServiceImpl.class, CountryDaoImpl.class,
        OrganizationControllerImpl.class, OrganizationServiceImpl.class, OrganizationDaoImpl.class,
        OfficeControllerImpl.class, OfficeServiceImpl.class, OfficeDaoImpl.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }

    @Bean
    public TaskExecutor controllerPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() + 1);
        executor.setQueueCapacity(25);
        return executor;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/api/.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST Sample with Swagger")
                .description("Spring REST Sample with Swagger")
                .contact("https://github.com/fr0zen87/Bell-Integrator-project")
                .version("1.0")
                .build();
    }
}