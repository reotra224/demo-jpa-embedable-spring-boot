package gn.traore.embedable.demoembedabledata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Address {
    @NotNull
    @Size(max = 100)
    private String addressLine1;

    @NotNull
    @Size(max = 100)
    private String addressLine2;

    @NotNull
    @Size(max = 100)
    private String city;

    @NotNull
    @Size(max = 100)
    private String state;

    @NotNull
    @Size(max = 100)
    private String country;

    @NotNull
    @Size(max = 6)
    private String zipCode;
}
