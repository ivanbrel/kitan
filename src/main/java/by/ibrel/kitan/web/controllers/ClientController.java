package by.ibrel.kitan.web.controllers;

import by.ibrel.kitan.logic.dao.entity.Client;
import by.ibrel.kitan.logic.exception.ClientExistsException;
import by.ibrel.kitan.logic.service.dto.ClientDto;
import by.ibrel.kitan.logic.service.impl.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class ClientController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IClientService service;

    @RequestMapping(value = {"/client/list"}, method = RequestMethod.GET)
    public String listClients(ModelMap model) {

        List<Client> clients = service.findAllClient();
        model.addAttribute("clients", clients);
        return "client.list";
    }

    //add new client
    @RequestMapping(value = {"/client/add"}, method = RequestMethod.POST)
    public String addClient(@Valid final ClientDto clientDto, final ModelMap model){
        LOGGER.debug("Add new client with name:" + clientDto);

        final Client add = createClient(clientDto);
        if (add==null){
            throw new ClientExistsException();
        }
        model.addAttribute("success");
        return "redirect:/client/list";
    }

    private Client createClient(ClientDto clientDto) {
        Client add;
        try{
            add = service.createClient(clientDto);
        }catch (final ClientExistsException e){
            return null;
        }
        return add;
    }

    @RequestMapping(value = {"/client/delete/{id}"}, method = RequestMethod.GET)
    public String deleteClient(@PathVariable Long id) {
        service.deleteClient(id);
        return "redirect:/client/list";
    }

    @RequestMapping(value = { "/client/edit/{id}" }, method = RequestMethod.POST)
    public String updateClient(@Valid final Client c, final BindingResult result, final ModelMap model){
        if (result.hasErrors()){return "client.edit";}
        service.updateClient(c);
        model.addAttribute("success", "Данные клиента " + c.getId() + " изменены");
        return "client.edit";
    }

    @RequestMapping(value = { "/client/edit/{id}" }, method = RequestMethod.GET)
    public String editClient(@PathVariable Long id, ModelMap model) {
        final Client client = service.findById(id);
        model.addAttribute("client", client);
        model.addAttribute("edit", true);
        return "client.edit";
    }
}
