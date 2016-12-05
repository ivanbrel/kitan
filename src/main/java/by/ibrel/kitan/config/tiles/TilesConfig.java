package by.ibrel.kitan.config.tiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author ibrel
 * @version 1.0
 * @email ibrel7n@gmail.com
 * @datecreate (05.12.2016)
 * @datechange (05.12.2016)
 */
@Configuration
public class TilesConfig {


    @Autowired
    private MessageSource messages;

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
        TilesDefinitionsConfig.addDefinitions(messages);
        return tilesConfigurer;
    }
}
