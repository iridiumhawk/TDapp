package com.iridiumhawk.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by hawk on 08.05.2016.
 */
/*public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}*/

public class AppInit implements WebApplicationInitializer {

    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.getEnvironment().setActiveProfiles("dev");
        ctx.register(Config.class, WebConfig.class, HibernateConfig.class); //
        ctx.setServletContext(container);
//        ctx.getEnvironment().setActiveProfiles("dev");

        // charset Filter enforcer
        FilterRegistration.Dynamic charsetFilter =
                container.addFilter("charsetFilter", CharacterEncodingFilter.class);
        charsetFilter.setInitParameter("encoding", "UTF-8");
        charsetFilter.setInitParameter("forceEncoding", "true");
        charsetFilter.addMappingForUrlPatterns(null, false, "/*");

        ServletRegistration.Dynamic servlet =
                container.addServlet("dispatcher", new DispatcherServlet(ctx));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }

}
