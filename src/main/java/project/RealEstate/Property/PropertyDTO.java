package project.RealEstate.Property;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.RealEstate.Owner.OwnerModel;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class PropertyDTO {

    private Long id;
    private String adress;
    private Double rentalValue;
    private String type;
    private String img_url;
    private OwnerModel owner;
}
