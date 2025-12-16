package project.RealEstate.Owner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.RealEstate.Property.PropertyModel;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDTO {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String number;
    private String img_url;
    private List<PropertyModel> property;
}
