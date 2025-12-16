package project.RealEstate.Property;

import org.springframework.stereotype.Component;

@Component
public class PropertyMapper {

    public PropertyModel map(PropertyDTO propertyDTO){
        PropertyModel propertyModel = new PropertyModel();

        propertyModel.setId(propertyDTO.getId());
        propertyModel.setType(propertyDTO.getType());
        propertyModel.setAdress((propertyDTO.getAdress()));
        propertyModel.setOwner(propertyDTO.getOwner());
        propertyModel.setImg_url(propertyDTO.getImg_url());
        propertyModel.setRentalValue(propertyDTO.getRentalValue());

        return propertyModel;
    }

    public PropertyDTO map (PropertyModel propertyModel){
        PropertyDTO propertyDTO = new PropertyDTO();

        propertyDTO.setId(propertyModel.getId());
        propertyDTO.setAdress(propertyModel.getAdress());
        propertyDTO.setType(propertyDTO.getType());
        propertyDTO.setOwner(propertyModel.getOwner());
        propertyDTO.setRentalValue(propertyModel.getRentalValue());
        propertyDTO.setImg_url(propertyModel.getImg_url());

        return propertyDTO;

    }
}
