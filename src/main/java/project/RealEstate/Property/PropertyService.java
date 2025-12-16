package project.RealEstate.Property;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;

    public PropertyService(PropertyRepository propertyRepository, PropertyMapper propertyMapper) {
        this.propertyRepository = propertyRepository;
        this.propertyMapper = propertyMapper;
    }

    //Create Property
    public PropertyDTO CreateProperty(PropertyDTO propertyDTO){

        PropertyModel Property = propertyMapper.map(propertyDTO);
        Property = propertyRepository.save(Property);
        return propertyMapper.map(Property);

    }

    //List all Property
    public List<PropertyDTO> listAllProperties(){
        List<PropertyModel> property = propertyRepository.findAll();
        return property.stream()
                .map(propertyMapper::map)
                .collect(Collectors.toList());

    }

    //List Properties by id
    public PropertyDTO listByidProperty(Long id){

        Optional<PropertyModel> propertybyid = propertyRepository.findById(id);
        return propertybyid.map(propertyMapper::map).orElse(null);
    }

    //Delete by id
    public void deleteProperty(Long id){
        propertyRepository.deleteById(id);

    }

    //Update Property By id
    public PropertyDTO updateProperty(Long id, PropertyDTO propertyDTO){
        Optional<PropertyModel> propertyExist = propertyRepository.findById(id);
        if (propertyExist.isPresent()){
            PropertyModel propertyupdate = propertyMapper.map(propertyDTO);
            propertyupdate.setId(id);
            PropertyModel propertySave = propertyRepository.save(propertyupdate);
            return propertyMapper.map(propertySave);

        }
        return null;
    }

    }

