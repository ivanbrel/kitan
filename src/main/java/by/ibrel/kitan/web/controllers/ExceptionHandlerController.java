package by.ibrel.kitan.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@ControllerAdvice
public class ExceptionHandlerController {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    public static final String DEFAULT_ERROR_VIEW = "kitan-errortrace";

    @ExceptionHandler(value = {ServletException.class,Exception.class, RuntimeException.class})
    public ModelAndView defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        logger.error("url:{}, exc:{}", request.getRequestURL(), e);
        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);

        mav.addObject("datetime", new Date());
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}
