package edu.uta.sis.cnfg.config.servlet1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Hannu Lohtander on 17.4.2016.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "edu.uta.sis.cnfg.web" })
@PropertySource(value = "classpath:app.properties", ignoreResourceNotFound = true)
public class Servlet1Config extends WebMvcConfigurerAdapter {

    /**
     * Property placeholder configurer needed to process @Value annotations
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "multipartResolver")
    public MultipartResolver getMultipartResolver() {
        return new org.springframework.web.multipart.support.StandardServletMultipartResolver();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/view/jsp",".jsp");
        super.configureViewResolvers(registry);
    }


}
