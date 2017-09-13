package management.client.controller;

import management.client.model.Client;
import management.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;

@Controller
@SessionAttributes("client")
public class ClientController extends HttpServlet {

    @Autowired
    private ClientService clientServiceImp;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView showClientList(Model model) {

        ModelAndView modelAndView = new ModelAndView("client");

        modelAndView.addObject("clients", clientServiceImp.findAll());

        Client client = (Client) model.asMap().get("createClient");

        if (client == null || client.getName() == null) {
            modelAndView.addObject("createClient", new Client());
        }

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "create")
    public String createClient(@Valid @ModelAttribute("createClient") Client client, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "redirect:/";
        }

        clientServiceImp.addClient(client);

        redirectAttributes.addFlashAttribute("Added client " + client.getName() + " successfully!");

        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "remove/{nif}")
    public String removeClient(@PathVariable("nif") String nif) {

        clientServiceImp.removeClient(nif);

        return "redirect:/";

    }

    // TODO: edit method
    @RequestMapping(method = RequestMethod.GET, value = "getClient/{nif}")
    public String getClient(@PathVariable("nif") String nif, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("createClient", clientServiceImp.findByNIF(nif));

        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST, value = "updateClient/{nif}")
    public String updateClient(@PathVariable("nif") String nif, @Valid @ModelAttribute("createClient") Client client, BindingResult bindingResult) {

        System.out.println(bindingResult.toString());
        System.out.println(client.toString());

        if (bindingResult.hasErrors()) {
            return "redirect:/";
        }

        clientServiceImp.editClient(nif, client);

        return "redirect:/";

    }

}