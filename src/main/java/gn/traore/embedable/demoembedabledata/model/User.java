package gn.traore.embedable.demoembedabledata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class User {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @EmbeddedId
    private UserIdentity identity;

    @Embedded
    private Name name;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_phone_numbers", joinColumns = {
            @JoinColumn(name = "company_id"),
            @JoinColumn(name = "user_id")
    })
    @Column(name = "phone_number")
    private Set<String> phoneNumbers = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_addresses", joinColumns = {
            @JoinColumn(name = "company_id"),
            @JoinColumn(name = "user_id")
    })
    @AttributeOverrides(value = {
            @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
    })
    private Set<Address> addresses = new HashSet<>();

    /*@Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
    })
    private Address address;*/
}
