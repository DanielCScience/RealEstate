package project.RealEstate.Owner;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> createOwner (@RequestBody OwnerDTO owner){

        OwnerDTO newOwner = ownerService.createOwner(owner);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Owner successfully registered: " + newOwner.getName() + " (ID: " + newOwner.getId() + ")");
    }


    @GetMapping("/list")
    public ResponseEntity<List<OwnerDTO>> listAllOwners(){
        List<OwnerDTO> listAllOwners = ownerService.listAllOwners();

        return ResponseEntity.ok((listAllOwners));
    }

    @GetMapping("/list/id")
    public ResponseEntity<?> listOwnerById(@PathVariable Long id){
        OwnerDTO ownerById = ownerService.listOwnersById(id);
        if (ownerById != null){
            return ResponseEntity.ok(ownerById);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Owner with ID " + id + " not found.");

        }

    }


    @PostMapping("/update/id")
    public ResponseEntity<?> OwnerUpdateById(@PathVariable Long id, @RequestBody OwnerDTO ownerDTO){
        OwnerDTO ownerUpdateById =ownerService.updateOwner(id, ownerDTO);

        if (ownerUpdateById != null){
            return ResponseEntity.ok(ownerUpdateById);

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Failed to update: Owner with ID " + id + " not found.");

        }


    }

    @DeleteMapping
    public ResponseEntity<String> deleteOwnerById(@PathVariable Long id){

        if(ownerService.listOwnersById(id) != null){
            ownerService.deleteOwner(id);
            return ResponseEntity.ok("Owner with ID " + id + " deleted successfully.");

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Owner with ID " + id + " not found.");
        }

    }


}
