package project.RealEstate.Property;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.RealEstate.Owner.OwnerService;

@Controller
@RequestMapping("/properties")
public class PropertyControllerUi {

    private final PropertyService propertyService;
    private final OwnerService ownerService;

    public PropertyControllerUi(PropertyService propertyService, OwnerService ownerService) {
        this.propertyService = propertyService;
        this.ownerService = ownerService;
    }

    @GetMapping("/list")
    public String listarProperties(Model model) {
        model.addAttribute("listaImoveis", propertyService.listAllProperties());
        return "listar-properties";
    }

    @GetMapping("/new")
    public String formularioProperty(Model model) {
        model.addAttribute("propertyDTO", new PropertyDTO());
        model.addAttribute("listaDonos", ownerService.listAllOwners());
        return "form-property";
    }

    @PostMapping("/save")
    public String salvarProperty(@ModelAttribute PropertyDTO propertyDTO) {
        propertyService.CreateProperty(propertyDTO);
        return "redirect:/properties/list";
    }

    @GetMapping("/delete/{id}")
    public String deletarProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return "redirect:/properties/list";
    }
}