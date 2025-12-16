package project.RealEstate.Owner;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.RealEstate.Property.PropertyModel;

import java.util.List;

@Entity
@Table(name = "Owner")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true)
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "number")
    private String number;

    @Column(name = "img_url")
    private String img_url;

    @OneToMany(mappedBy = "owner")
    private List<PropertyModel> property;
}
