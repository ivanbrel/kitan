package by.ibrel.kitan.config;

import by.ibrel.kitan.config.tiles.TilesDefinitionsConfig;
import by.ibrel.kitan.logic.service.converters.CustomWebBindingInitializer;
import by.ibrel.kitan.logic.service.converters.StringToProductCategoryConverter;
import by.ibrel.kitan.logic.service.converters.StringToProductColorConverter;
import by.ibrel.kitan.logic.service.converters.StringToProductConverter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static by.ibrel.kitan.constants.PageConstants.*;
import static by.ibrel.kitan.constants.UrlConstants.*;

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

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private ConversionService conversionService;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToProductConverter());
        registry.addConverter(stringToProductCategoryConverter());
        registry.addConverter(stringToProductColorConverter());
    }

    /*
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController(LOGIN_URL).setViewName(LOGIN_PAGE);
        registry.addViewController(HOME_URL).setViewName(HOME_PAGE);
        registry.addViewController(CONTACT_URL).setViewName(CONTACTS_PAGE);
        registry.addViewController(HELP_URL).setViewName(HELP_PAGE);
        registry.addViewController(REF_URL).setViewName(REF_PAGE);
        registry.addViewController(ABOUT_URL).setViewName(ABOUT_PAGE);
        registry.addViewController(USER_LIST_URL).setViewName(USER_LIST_PAGE);
        registry.addViewController(USER_EDIT_URL).setViewName(USER_EDIT_PAGE);
        registry.addViewController(ROLE_LIST_URL).setViewName(ROLE_LIST_PAGE);
        registry.addViewController(CLIENT_LIST_URL).setViewName(CLIENT_LIST_PAGE);
        registry.addViewController(CLIENT_ADD_URL).setViewName(CLIENT_ADD_PAGE);
        registry.addViewController(CART_LIST_URL).setViewName(CART_LIST_PAGE);
        registry.addViewController(PRODUCT_LIST_URL).setViewName(PRODUCT_LIST_PAGE);
        registry.addViewController(PRODUCT_ADD_URL).setViewName(PRODUCT_ADD_PAGE);
        registry.addViewController(CART_SHOW_URL).setViewName(CART_SHOW_PAGE);
        registry.addViewController(PRICE_LIST_URL).setViewName(PRICE_LIST_PAGE);
        registry.addViewController(PRICE_ADD_URL).setViewName(PRICE_ADD_PAGE);
        registry.addViewController(PRODUCT_CATEGORY_LIST_URL).setViewName(PRODUCT_CATEGORY_LIST_PAGE);
        registry.addViewController(PRODUCT_COLOR_LIST_URL).setViewName(PRODUCT_COLOR_LIST_PAGE);
        registry.addViewController(ERROR_404_URL).setViewName(ERROR_404_PAGE);
        registry.addViewController(ERROR_405_URL).setViewName(ERROR_405_PAGE);
        registry.addViewController(ERROR_TRACE_URL).setViewName(ERROR_TRACE_PAGE);
        registry.addViewController(ERROR_403_URL).setViewName(ERROR_403_PAGE);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(byteArrayHttpMessageConverter());
        converters.add(mappingJackson2HttpMessageConverter());

//        // http
//        HttpMessageConverter converter = new StringHttpMessageConverter();
//        converters.add(converter);
//        LOGGER.info("HttpMessageConverter added");
//
//        // string
//        converter = new FormHttpMessageConverter();
//        converters.add(converter);
//        LOGGER.info("FormHttpMessageConverter added");
//
//        // json
//        converter = new MappingJackson2HttpMessageConverter();
//        converters.add(converter);
//        LOGGER.info("MappingJackson2HttpMessageConverter added");
    }

    /**
     * Configure ViewResolvers to deliver preferred views.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(getTilesViewResolver());
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }

    /**
     * Resolves views selected for rendering by @Controllers to tiles resources in the Apache TilesConfigurer bean
     */
    @Bean
    public TilesViewResolver getTilesViewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        return tilesViewResolver;
    }

    /**
     * Configures Apache tiles definitions bean used by Apache TilesViewResolver to resolve views selected for rendering by @Controllers
     */
    @Bean
    public TilesConfigurer getTilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setCheckRefresh(true);
        tilesConfigurer.setDefinitionsFactoryClass(TilesDefinitionsConfig.class);
        //       enabling auto-refresh of Tiles definitions
        tilesConfigurer.setPreparerFactoryClass(SpringBeanPreparerFactory.class);

        // Add apache tiles definitions
        TilesDefinitionsConfig.addDefinitions(messageSource());

        LOGGER.info("TilesDefinitionsConfig - successfully added definitions");
        return tilesConfigurer;
    }

    @Override
    public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false)
                .favorParameter(true)
                .parameterName("mediaType")
                .ignoreAcceptHeader(true)
                .useJaf(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("json", MediaType.APPLICATION_JSON);
    }

    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setOrder(1);
        resolver.setViewResolvers(Lists.newArrayList(getTilesViewResolver()));
        return resolver;
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
        adapter.setWebBindingInitializer(customWebBindingInitializer());
        return adapter;
    }

    @Bean
    public CustomWebBindingInitializer customWebBindingInitializer(){
        return new CustomWebBindingInitializer(conversionService);
    }

    @Bean
    public ConversionServiceFactoryBean conversionService(){
        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
        factoryBean.setConverters(Sets.newHashSet(stringToProductCategoryConverter(),stringToProductConverter(), stringToProductColorConverter()));
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
        LOGGER.info("String to ProductCategory converter add");
        return new StringToProductCategoryConverter();
    }

    @Bean
    public Converter stringToProductColorConverter(){
        LOGGER.info("String to ProductColor converter add");
        return new StringToProductColorConverter();
    }

    @Bean
    public Converter stringToProductConverter(){
        LOGGER.info("String to Product converter add");
        return new StringToProductConverter();
    }

    @Bean
    public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
        ByteArrayHttpMessageConverter arrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
        arrayHttpMessageConverter.setSupportedMediaTypes(getSupportedMediaTypes());
        return arrayHttpMessageConverter;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //objectMapper.registerModule(new JSR310Module());
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
        converter.setSupportedMediaTypes(getJsonMediaTypes());
        return converter;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        source.setUseCodeAsDefaultMessage(true);
        source.setDefaultEncoding("UTF-8");
        return source;
    }

    @Bean
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setCookieName("defaultLocale");
        cookieLocaleResolver.setDefaultLocale(new Locale("ru"));
        return cookieLocaleResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor=new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }

    private List<MediaType> getSupportedMediaTypes() {
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.IMAGE_JPEG);
        list.add(MediaType.IMAGE_PNG);
        list.add(MediaType.APPLICATION_OCTET_STREAM);
        return list;
    }

    private List<MediaType> getJsonMediaTypes(){
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON);
        list.add(MediaType.APPLICATION_JSON_UTF8);
        list.add(MediaType.ALL);
        return list;
    }
}