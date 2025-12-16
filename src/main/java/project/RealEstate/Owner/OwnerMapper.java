package project.RealEstate.Owner;
import org.springframework.stereotype.Component;
import project.RealEstate.Owner.OwnerDTO;

@Component
public class OwnerMapper {

    public OwnerModel map(OwnerDTO ownerDTO) {
        OwnerModel ownerModel = new OwnerModel();

        ownerModel.setId(ownerDTO.getId());
        ownerModel.setName(ownerDTO.getName());
        ownerModel.setCpf(ownerDTO.getCpf());
        ownerModel.setEmail(ownerDTO.getEmail());
        ownerModel.setNumber(ownerDTO.getNumber());
        ownerModel.setImg_url(ownerDTO.getImg_url());
        ownerModel.setProperty(ownerDTO.getProperty());

        return ownerModel;
    }

    public OwnerDTO map(OwnerModel ownerModel) {
        OwnerDTO ownerDTO = new OwnerDTO();

        ownerDTO.setId(ownerModel.getId());
        ownerDTO.setName(ownerModel.getName());
        ownerDTO.setCpf(ownerModel.getCpf());
        ownerDTO.setEmail(ownerModel.getEmail());
        ownerDTO.setNumber(ownerModel.getNumber());
        ownerDTO.setImg_url(ownerModel.getImg_url());
        ownerDTO.setProperty(ownerModel.getProperty());

        return ownerDTO;
    }
}