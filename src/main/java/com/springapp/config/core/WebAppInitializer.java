package com.springapp.config.core;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.springapp.config.DaoConfig;
import com.springapp.config.SecurityConfig;
import com.springapp.config.ServiceConfig;
import com.springapp.config.WebMvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//public class WebAppInitializer implements WebApplicationInitializer {
//
//    public void onStartup(ServletContext servletContext) throws ServletException {
//
//        // Setup DispatcherTypes
//        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
//
//        // Setup the UTF-8 Filter
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setEncoding("UTF-8");
//        FilterRegistration.Dynamic characterEncodingRegistration = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
//        characterEncodingRegistration.addMappingForServletNames(dispatcherTypes, true, "mvcServlet");
//
//        // Setup the main Spring Application Context through ContextLoaderListener
//        AnnotationConfigWebApplicationContext mainContext = new AnnotationConfigWebApplicationContext();
//        mainContext.register(DaoConfig.class, ServiceConfig.class);
//        servletContext.addListener(new ContextLoaderListener(mainContext));
//
//        // Setup the MVC Servlet Context through DispatcherServlet
//        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
//        mvcContext.register(WebMvcConfig.class);
//        ServletRegistration.Dynamic mvcDispatcher = servletContext.addServlet("mvcServlet", new DispatcherServlet(mvcContext));
//        mvcDispatcher.addMapping("*.html");
//        mvcDispatcher.addMapping("*.ajax");
//    }
//}

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SecurityConfig.class, DaoConfig.class, ServiceConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "*.html", "*.ajax" };
    }

}