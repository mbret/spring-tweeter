package com.springapp.config;

import com.springapp.domain.ScopedObject;
import com.springapp.domain.ScopedValue;
import com.springapp.domain.model.User;
import com.springapp.web.Route;
import com.springapp.web.mvc.interceptor.ShouldBeLoggedInterceptor;
import com.springapp.web.mvc.interceptor.ShouldNotBeLoggedInterceptor;
import com.springapp.web.mvc.interceptor.ViewConfigInjectorInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Properties;

@Configuration
@ComponentScan({
        "com.springapp.web.mvc",
        "com.springapp.web.validation"
})
@EnableWebMvc // <mvc:annotation-driven/>
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/media/**").addResourceLocations("/media/").setCachePeriod(31556926);
//        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
//        registry.addResourceHandler("/images/**").addResourceLocations("/images/").setCachePeriod(31556926);
//        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(viewConfigInterceptor())
                .addPathPatterns("/**");
        registry.addInterceptor(shouldBeLoggedInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/api/**")
                .excludePathPatterns(Route.login)
                .excludePathPatterns(Route.register);
        registry.addInterceptor(shouldNotBeLoggedInterceptor())
                .addPathPatterns(Route.login)
                .addPathPatterns(Route.register);
    }
    
    /**
     * InternalResourceViewResolver
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setContentType("UTF-8");
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
    /**
     * We define a scoped bean that stock an user into session.
     * @return
     */
    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
    @Qualifier("current-user")
    public ScopedValue<User> currentUser() {
        return new ScopedObject<>();
    }


    
    /**
     * Set the 500 page when server exception is thrown.
     * @return
     */
    @Bean(name = "simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver= new SimpleMappingExceptionResolver();

        Properties mappings = new Properties();
        resolver.setExceptionMappings(mappings); // None by default
        resolver.setExceptionAttribute("ErrorOccurred"); // Default is "exception"
        resolver.setDefaultErrorView("../common/500"); // 500.jsp
        return resolver;
    }

    
    @Bean
    public HandlerInterceptor shouldBeLoggedInterceptor() {
        return new ShouldBeLoggedInterceptor();
    }
    
    @Bean
    public HandlerInterceptor shouldNotBeLoggedInterceptor() {
        return new ShouldNotBeLoggedInterceptor();
    }

    @Bean
    public HandlerInterceptor viewConfigInterceptor(){
        return new ViewConfigInjectorInterceptor();
        
    }
}
