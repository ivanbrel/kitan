package by.ibrel.kitan.logic.service.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * @author ibrel
 * @version 1.0 (27/09/16)
 */
public class CustomWebBindingInitializer implements WebBindingInitializer {

    private final ConversionService conversionService;

    @Autowired
    public CustomWebBindingInitializer(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        webDataBinder.setConversionService(conversionService);
    }
}
