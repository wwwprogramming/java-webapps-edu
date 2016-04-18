package edu.uta.sis.cnfg;

import edu.uta.sis.cnfg.config.app.AppConfig;
import edu.uta.sis.cnfg.config.servlet1.Servlet1Config;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.MultipartConfig;

/**
 * Created by Hannu Lohtander on 17.4.2016.
 */


public class CnfgWebApplicationInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {


        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));


        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("edu.uta.sis.cnfg.config.servlet1");

        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        registration.setMultipartConfig(new MultipartConfigElement("", 1024 * 1024 * 5, 1024 * 1024 * 5 * 5, 1024 * 1024));

        registration.setLoadOnStartup(1);
        registration.addMapping("/");

//        // OR
//        AnnotationConfigWebApplicationContext dispatcherContext =
//                new AnnotationConfigWebApplicationContext();
//        dispatcherContext.register(Servlet1Config.class);
//
//
//        // Register and map the dispatcher servlet
//        ServletRegistration.Dynamic dispatcher =
//                servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
    }
}
