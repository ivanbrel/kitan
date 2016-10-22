package by.ibrel.kitan.web.controllers;

import by.ibrel.kitan.logic.service.AbstractService;
import by.ibrel.kitan.logic.service.ICommonService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author ibrel
 * @version 1.0 (06/10/16)
 */
@Controller
public abstract class AbstractController <T extends Serializable> implements Serializable,ICommonController<T>{

    private ICommonService<T> abstractService;

    public AbstractController(ICommonService<T> abstractService) {
        this.abstractService = abstractService;
    }

    public String listEntity(ModelMap modelMap, final String returnPage){
        Collection<T> collection = abstractService.findAll();
        modelMap.addAttribute("list",collection);
        return returnPage;
    }

    public String deleteEntity(final Long id, ModelMap modelMap, final String returnPage){
        try{
            abstractService.delete(id);
        }catch (Exception e){
            modelMap.addAttribute("fail", true);
            return listEntity(modelMap,returnPage);
        }
        return listEntity(modelMap,returnPage);
    }

    public String initForm(final Long id, ModelMap modelMap, List<?> lists, String returnPage){

        final T entity = abstractService.findOne(id);
        modelMap.addAttribute("entity",entity);
        modelMap.addAttribute("lists",lists);
        return returnPage;
    }

    public String update(T entity, final BindingResult result, ModelMap modelMap, final String returnPage){
        if (result.hasErrors()){
            return returnPage;
        }
        abstractService.update(entity);
        return listEntity(modelMap, returnPage);
    }

    public String create(Object o, ModelMap modelMap, final String returnPage){
        abstractService.create(o);
        return listEntity(modelMap,returnPage);
    }
}
