//package by.ibrel.kitan.config;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.request.RequestContextListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.filter.DelegatingFilterProxy;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.*;
//import java.util.EnumSet;
//
///**
// * @author ibrel
// * @version 1.0
// * @email ibrel7n@gmail.com
// * @datecreate (30.11.2016)
// * @datechange (30.11.2016)
// */
//public class AppInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext container) throws ServletException {
//
//// Creates the root application context
//        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
//
//        appContext.setDisplayName("Ivan Brel API");
//
//// Registers the application configuration with the root context
////        appContext.register(WebConfig.class);
//
//// Creates the Spring Container shared by all Servlets and Filters
//        container.addListener(new ContextLoaderListener(appContext));
//        container.addListener(RequestContextListener.class);
//
//        // Creates the dispatcher servlet context
//        AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();
//
//// Registers the servlet configuraton with the dispatcher servlet context
////        servletContext.register(WebConfig.class);
//
//// Further configures the servlet context
//        ServletRegistration.Dynamic dispatcher = container.addServlet("appDispatcher", new DispatcherServlet(servletContext));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//
//        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
//
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setEncoding("UTF-8");
//        characterEncodingFilter.setForceEncoding(true);
//
//        FilterRegistration.Dynamic characterEncoding = container.addFilter("characterEncoding", characterEncodingFilter);
//        characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
//
//        FilterRegistration.Dynamic security = container.addFilter("springSecurityFilterChain", new DelegatingFilterProxy());
//        security.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
//
//
//    }
//}
