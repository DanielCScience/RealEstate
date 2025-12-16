package project.RealEstate.Property;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private final PropertyService propertyService;

    // Injeção de dependência via construtor
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    // CREATE
    @PostMapping("/new")
    public ResponseEntity<String> createProperty(@RequestBody PropertyDTO propertyDTO) {

        PropertyDTO newProperty = propertyService.CreateProperty(   propertyDTO);

        // Retorna mensagem com o Endereço e o ID
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Property successfully registered: " + newProperty.getAdress() + " (ID: " + newProperty.getId() + ")");
    }

    // LIST ALL
    @GetMapping("/list")
    public ResponseEntity<List<PropertyDTO>> listAllProperties() {
        List<PropertyDTO> listAllProperties = propertyService.listAllProperties();
        return ResponseEntity.ok(listAllProperties);
    }

    // LIST BY ID
    // Corrigido: Adicionei as chaves {id}
    @GetMapping("/list/{id}")
    public ResponseEntity<?> listPropertyById(@PathVariable Long id) {

        PropertyDTO propertyById = propertyService.listByidProperty(id);

        if (propertyById != null) {
            return ResponseEntity.ok(propertyById);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Property with ID " + id + " not found.");
        }
    }

    // UPDATE
    // Corrigido: Adicionei as chaves {id} e mudei para PUT (padrão de atualização)
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePropertyById(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO) {

        PropertyDTO propertyUpdated = propertyService.updateProperty(id, propertyDTO);

        if (propertyUpdated != null) {
            return ResponseEntity.ok(propertyUpdated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Failed to update: Property with ID " + id + " not found.");
        }
    }

    // DELETE
    // Corrigido: Adicionei as chaves {id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePropertyById(@PathVariable Long id) {

        if (propertyService.listByidProperty(id) != null) {
            propertyService.deleteProperty(id);
            return ResponseEntity.ok("Property with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Property with ID " + id + " not found.");
        }
    }
}