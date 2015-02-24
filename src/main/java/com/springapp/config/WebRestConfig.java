package com.springapp.config;

import com.springapp.domain.ScopedObject;
import com.springapp.domain.ScopedValue;
import com.springapp.domain.model.User;
import com.springapp.web.rest.inteceptor.BasicAuthInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Properties;

//@Configuration
//@Import(RepositoryRestMvcConfiguration.class)
//public class WebRestConfig extends RepositoryRestMvcConfiguration {
//
//    // … further configuration
//}

@Configuration
@ComponentScan({
        "com.springapp.web.rest",
        "com.springapp.web.validation.support"
})
@EnableWebMvc
public class WebRestConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        super.addInterceptors(registry);
        registry.addInterceptor(basicAuthInterceptor())
                .addPathPatterns("/api/**");

    }

    @Bean
    @Scope( value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    @Qualifier("api-user")
    public ScopedValue<User> apiUser(){
        return new ScopedObject<>();
    }

    @Bean
    public HandlerInterceptor basicAuthInterceptor(){
        return new BasicAuthInterceptor();
    }
    

}
