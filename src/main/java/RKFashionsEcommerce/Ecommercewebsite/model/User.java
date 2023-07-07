package RKFashionsEcommerce.Ecommercewebsite.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
   @Column(nullable = false)
   @NotEmpty
   private String firstName;
   private String lastName;
   @Column (nullable = false, unique = true)
   @NotEmpty
   @Email(message = "{errors.invalid_email}")
    private String email;
    @NotEmpty
    private String password;
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(
            name ="user_role",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
                inverseJoinColumns = {@JoinColumn (name = "ROLE_ID", referencedColumnName = "ID")}
    )
    private List<Role> roles;



}
