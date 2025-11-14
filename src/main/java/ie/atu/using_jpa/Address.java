package ie.atu.using_jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String county;

    @NotBlank
    private String eircode;

    public Address(String county, String eircode) {
        this.county = county;
        this.eircode = eircode;
    }
}
