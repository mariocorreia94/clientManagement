package multicert.exercicio.controller;

import multicert.exercicio.model.Client;
import multicert.exercicio.service.MockClientService;
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
    private MockClientService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView showUserList(Model model) {

        ModelAndView modelAndView = new ModelAndView("client");

        modelAndView.addObject("clients", userService.getClientList());

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

        userService.addClient(client);

        redirectAttributes.addFlashAttribute("Added client " + client.getName() + " successfully!");

        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "remove/{nif}")
    public String removeClient(Model model, @PathVariable("nif") String nif) {

        //userService.removeClient(userService.findByNIF(nif));

        return "redirect:/";

    }

    public void setUserService(MockClientService userService) {
        this.userService = userService;
    }
}