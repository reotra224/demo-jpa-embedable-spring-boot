package gn.traore.embedable.demoembedabledata.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor @ToString @EqualsAndHashCode
public class UserIdentity implements Serializable {

    @NotNull
    private Long userId;

    @NotNull
    private Long companyId;
}
