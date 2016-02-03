package net.smartrss;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterConfig;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import net.smartrss.admin.view.app.AnalyzerWebApplication;
import org.apache.wicket.protocol.http.WicketFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * Created by Alexander on 03.02.2016.
 */
public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        //Create webapp context

        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext(); //part of spring-web
        root.register(SpringSecurityConfiguration.class); //register class by annotation. Here be all security rules.

        root.setConfigLocation("/WEB-INF/applicationContext.xml");

        //Register DelegatingFilterProxy
        FilterRegistration.Dynamic springSecurityFilterChainReg = servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
        springSecurityFilterChainReg.addMappingForUrlPatterns(EnumSet.of(DispatcherType.ERROR, DispatcherType.REQUEST), false, "/*");

        servletContext.addListener(new ContextLoaderListener(root));

        //Register WicketFilter
        WicketFilter wicketFilter = new WicketFilter(new AnalyzerWebApplication()) {
            @Override
            public void init(boolean isServlet, FilterConfig filterConfig) throws ServletException {
                setFilterPath(""); //don't use web.xml. WicketApplication.init is a custom override for it.
                super.init(isServlet, filterConfig);
            }
        };
        FilterRegistration.Dynamic wicketFilterReg = servletContext.addFilter("wicketFilter", wicketFilter);
        wicketFilterReg.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "*");
    }
}
