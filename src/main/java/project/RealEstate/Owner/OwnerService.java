package project.RealEstate.Owner;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OwnerService {
    private final OwnerMapper ownerMapper;
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerMapper ownerMapper, OwnerRepository ownerRepository) {
        this.ownerMapper = ownerMapper;
        this.ownerRepository = ownerRepository;
    }

    //Create Owner
    public OwnerDTO createOwner(OwnerDTO ownerDTO){
        OwnerModel Owner = ownerMapper.map(ownerDTO);
        Owner = ownerRepository.save(Owner);
        return ownerMapper.map(Owner);

    }

    //List all Owners
    public List<OwnerDTO> listAllOwners(){
        List<OwnerModel> owner = ownerRepository.findAll();
        return owner.stream()
                .map(ownerMapper::map)
                .collect(Collectors.toList());

    }

    //List Owner By id
    public OwnerDTO listOwnersById(Long id){
        Optional<OwnerModel> ownerById = ownerRepository.findById(id);
        return ownerById.map(ownerMapper::map).orElse(null);

    }

    //Delete owner
    public void deleteOwner(Long id){
       ownerRepository.deleteById(id);
    }

    //Update Owner
    public OwnerDTO updateOwner(Long id, OwnerDTO ownerDTO){
        Optional<OwnerModel> ownerExist = ownerRepository.findById(id);
        if (ownerExist.isPresent()){
            OwnerModel ownerUpdate = ownerMapper.map(ownerDTO);
            ownerUpdate.setId(id);
            OwnerModel ownerSave = ownerRepository.save(ownerUpdate);
            return ownerMapper.map(ownerSave);

        }
        return null;
    }
}

