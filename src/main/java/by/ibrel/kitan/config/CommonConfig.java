package by.ibrel.kitan.config;

import by.ibrel.kitan.logic.service.converters.CustomWebBindingInitializer;
import by.ibrel.kitan.logic.service.converters.StringToProductCategoryConverter;
import by.ibrel.kitan.logic.service.converters.StringToProductConverter;
import by.ibrel.kitan.logic.validation.PasswordMatchesValidator;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import javax.validation.ConstraintValidator;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ibrel
 * @version 1.0
 * @email ibrel7n@gmail.com
 * @datecreate (23.11.2016)
 * @datechange (23.11.2016)
 */
@EnableWebMvc
@Configuration
@ComponentScan("by.ibrel.kitan")
public class CommonConfig extends WebMvcConfigurerAdapter {

    /*
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login_").setViewName("auth.login");
        registry.addViewController("/home").setViewName("main.home");
        registry.addViewController("/contacts").setViewName("main.contacts");
        registry.addViewController("/help").setViewName("main.help");
        registry.addViewController("/ref").setViewName("main.ref");
        registry.addViewController("/about").setViewName("main.about");
        registry.addViewController("/user/admin/list").setViewName("auth.user.list");
        registry.addViewController("/user/edit").setViewName("auth.user.edit");
        registry.addViewController("/role/list").setViewName("auth.role.list");
        registry.addViewController("/users/add-page").setViewName("auth.user.add");
        registry.addViewController("/client/list").setViewName("client.list");
        registry.addViewController("/client/add-page").setViewName("client.add");
        registry.addViewController("/cart/list").setViewName("purchase.list");
        registry.addViewController("/product/list").setViewName("product.list");
        registry.addViewController("/product/add-page").setViewName("product.add");
        registry.addViewController("/cart/show").setViewName("purchase.show");
        registry.addViewController("/configuration/price/list").setViewName("price.list");
        registry.addViewController("/configuration/price/add-page").setViewName("price.add");
        registry.addViewController("/configuration/product-category/list").setViewName("product.category.list");
        registry.addViewController("/configuration/product-color/list").setViewName("product.color.list");
        registry.addViewController("/error/404").setViewName("error.404");
        registry.addViewController("/error/405").setViewName("error.405");
        registry.addViewController("/error/trace").setViewName("error.trace");
        registry.addViewController("/error/403").setViewName("error.403");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(byteArrayHttpMessageConverter());
    }

    /*
      HandlerMethodArgumentResolver to automatically create Sort instances from request parameters or SortDefault annotations.
     */
    @Bean
    public HandlerMethodArgumentResolver sortResolver(){
        return new SortHandlerMethodArgumentResolver();
    }

    @Bean
    public HandlerMethodArgumentResolver pageableResolver(){
        return new PageableHandlerMethodArgumentResolver((SortHandlerMethodArgumentResolver) sortResolver());
    }

    /*
     * Convenient subclass of UrlBasedViewResolver that supports InternalResourceView (i.e. Servlets and JSPs) and subclasses such as JstlView.
     */
    @Bean
    public InternalResourceViewResolver jspViewResolver(){
        InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
        jspViewResolver.setViewClass(JstlView.class);
        jspViewResolver.setPrefix("/WEB-INF/kitan/tiles/");
        jspViewResolver.setSuffix(".jsp");
        jspViewResolver.setOrder(2);
        return jspViewResolver;
    }

    /*
     * Configure ContentNegotiationManager
     */
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.ignoreAcceptHeader(true).defaultContentType(
//                MediaType.APPLICATION_XML);
//    }

    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setOrder(1);

        // Define all possible view resolvers
//        resolvers.add(jaxb2MarshallingXmlViewResolver());
//        resolvers.add(jsonViewResolver());
//        resolvers.add(pdfViewResolver());
//        resolvers.add(excelViewResolver());

        resolver.setViewResolvers(Lists.newArrayList(jspViewResolver(),tilesViewResolver()));
        return resolver;
    }

    /*
     * Configure View resolver to provide JSON output using JACKSON library to
     * convert object in JSON format.
     */
//    @Bean
//    public ViewResolver jsonViewResolver() {
//        return new JsonViewResolver();
//    }

    /*
     * Configure View resolver to provide PDF output using lowagie pdf library to
     * generate PDF output for an object content
     */
//    @Bean
//    public ViewResolver pdfViewResolver() {
//        return new PdfViewResolver();
//    }

    /*
     * Configure View resolver to provide XLS output using Apache POI library to
     * generate XLS output for an object content
     */
//    @Bean
//    public ViewResolver excelViewResolver() {
//        return new ExcelViewResolver();
//    }

    @Bean
    public TilesViewResolver tilesViewResolver(){
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setOrder(2);
        return tilesViewResolver;
    }

    /**
     * Configure TilesConfigurer.
     */
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("classpath:tiles-kitan.xml");
        tilesConfigurer.setCheckRefresh(true);

//       enabling auto-refresh of Tiles definitions
        tilesConfigurer.setPreparerFactoryClass(SpringBeanPreparerFactory.class);
        return tilesConfigurer;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public ConstraintValidator passwordMatchesValidator(){
        return new PasswordMatchesValidator();
    }

    @Bean
    public RequestMappingHandlerMapping valueResolverAware(){
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
        adapter.setWebBindingInitializer(customWebBindingInitializer());
        return adapter;
    }

    @Bean
    public CustomWebBindingInitializer customWebBindingInitializer(){
        return new CustomWebBindingInitializer();
    }

    @Bean
    public ConversionServiceFactoryBean conversionService(){
        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
        factoryBean.setConverters(Sets.newHashSet(stringToProductCategoryConverter(),stringToProductConverter()));
        return factoryBean;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(20971520);
        multipartResolver.setMaxInMemorySize(1048576);
        return multipartResolver;
    }

    @Bean
    public Converter stringToProductCategoryConverter(){
        return new StringToProductCategoryConverter();
    }

    @Bean
    public Converter stringToProductConverter(){
        return new StringToProductConverter();
    }

    @Bean
    public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
        ByteArrayHttpMessageConverter arrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
        arrayHttpMessageConverter.setSupportedMediaTypes(getSupportedMediaTypes());
        return arrayHttpMessageConverter;
    }

    private List<MediaType> getSupportedMediaTypes() {
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.IMAGE_JPEG);
        list.add(MediaType.IMAGE_PNG);
        list.add(MediaType.APPLICATION_OCTET_STREAM);
        return list;
    }
}