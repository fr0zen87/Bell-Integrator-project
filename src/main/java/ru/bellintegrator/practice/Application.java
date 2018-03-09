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
import ru.bellintegrator.practice.countries.controller.CountriesControllerImpl;
import ru.bellintegrator.practice.documents.controller.DocumentsControllerImpl;
import ru.bellintegrator.practice.countries.dao.CountryDAOImpl;
import ru.bellintegrator.practice.documents.dao.DocumentsDAOImpl;
import ru.bellintegrator.practice.countries.service.CountriesServiceImpl;
import ru.bellintegrator.practice.documents.service.DocumentsServiceImpl;
import ru.bellintegrator.practice.office.controller.OfficeControllerImpl;
import ru.bellintegrator.practice.office.dao.OfficeDAOImpl;
import ru.bellintegrator.practice.office.service.OfficeServiceImpl;
import ru.bellintegrator.practice.organization.controller.OrganizationControllerImpl;
import ru.bellintegrator.practice.organization.dao.OrganizationDAOImpl;
import ru.bellintegrator.practice.organization.service.OrganizationServiceImpl;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Locale;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@ImportResource("spring_mvc_config.xml")
@SpringBootApplication
@ComponentScan(basePackageClasses = {
        DocumentsControllerImpl.class, DocumentsServiceImpl.class, DocumentsDAOImpl.class,
        CountriesControllerImpl.class, CountriesServiceImpl.class, CountryDAOImpl.class,
        OrganizationControllerImpl.class, OrganizationServiceImpl.class, OrganizationDAOImpl.class,
        OfficeControllerImpl.class, OfficeServiceImpl.class, OfficeDAOImpl.class
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
    public Docket postApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("persons").apiInfo(apiInfo()).
                select().paths(regex("/person.*")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST Sample with Swagger")
                .description("Spring REST Sample with Swagger")
                .contact("https://github.com/azEsm/empty_project")
                .version("1.0")
                .build();
    }
}