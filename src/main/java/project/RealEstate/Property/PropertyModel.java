package project.RealEstate.Property;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.RealEstate.Owner.OwnerModel;

@Entity
@Table(name = "Property")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PropertyModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adress")
    private String adress;

    @Column(name = "rentalValue")
    private Double rentalValue;

    @Column(name = "Type")
    private String type;

    @Column(name = "img_url")
    private String img_url;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private OwnerModel owner;
}
