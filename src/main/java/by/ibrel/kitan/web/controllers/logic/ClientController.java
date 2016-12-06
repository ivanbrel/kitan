package by.ibrel.kitan.web.controllers.logic;

import by.ibrel.kitan.logic.dao.logic.entity.Client;
import by.ibrel.kitan.logic.dao.logic.entity.dto.ClientDto;
import by.ibrel.kitan.logic.service.logic.impl.IClientService;
import by.ibrel.kitan.web.controllers.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import static by.ibrel.kitan.constants.PageConstants.CLIENT_LIST_PAGE;
import static by.ibrel.kitan.constants.PageConstants.CLIENT_EDIT_PAGE;

/**
 * @author ibrel
 * @version 1.2 (26.06.2016)
 */

@Controller
@RequestMapping("/")
public class ClientController extends AbstractController<Client> {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public ClientController(final IClientService clientService) {
        super(clientService);
    }

    @RequestMapping(value = {"/client/list"}, method = RequestMethod.GET)
    public String listClients(ModelMap model) {
        return listEntity(model, CLIENT_LIST_PAGE);
    }

    @RequestMapping(value = {"/client/add"}, method = RequestMethod.POST)
    public String addClient(@Valid final ClientDto clientDto, final ModelMap model){
        Object o = clientDto;
        return create(o,model,listClients(model));
    }

    @RequestMapping(value = {"/client/delete/{id}"}, method = RequestMethod.GET)
    public String deleteClient(@PathVariable Long id,  final ModelMap model) {
        return deleteEntity(id,model,listClients(model));
    }

    @RequestMapping(value = { "/client/edit/{id}" }, method = RequestMethod.POST)
    public String updateClient(@Valid final Client client, final BindingResult result, final ModelMap model){
        return update(client,result,model,listClients(model));
    }

    @RequestMapping(value = { "/client/edit/{id}" }, method = RequestMethod.GET)
    public String editClient(@PathVariable Long id, ModelMap model) {
        return initForm(id,model, null, CLIENT_EDIT_PAGE);
    }
}
