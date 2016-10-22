package by.ibrel.kitan.web.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * @author ibrel
 * @version 1.0 (18/10/16)
 */
interface ICommonController<T> {

    String deleteEntity(final Long id, ModelMap modelMap, final String returnPage);

    String initForm(final Long id, ModelMap modelMap, List<?> lists, String returnPage);

    String update(T entity, final BindingResult result, ModelMap modelMap, final String returnPage);

    String create(Object o, ModelMap modelMap, final String returnPage);
}
