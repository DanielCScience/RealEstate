package project.RealEstate.Owner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owners")
public class OwnerControllerUi {

    private final OwnerService ownerService;

    public OwnerControllerUi(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/list")
    public String listarOwners(Model model) {
        model.addAttribute("listaOwners", ownerService.listAllOwners());
        return "listar-owners";
    }

    @GetMapping("/new")
    public String formularioOwner(Model model) {
        model.addAttribute("ownerDTO", new OwnerDTO());
        return "form-owner";
    }

    @PostMapping("/save")
    public String salvarOwner(@ModelAttribute OwnerDTO ownerDTO) {
        ownerService.createOwner(ownerDTO);
        return "redirect:/owners/list"; // Redireciona para a url limpa
    }

    @GetMapping("/delete/{id}")
    public String deletarOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return "redirect:/owners/list";
    }
}