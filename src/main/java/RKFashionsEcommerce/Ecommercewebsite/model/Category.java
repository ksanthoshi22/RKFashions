package RKFashionsEcommerce.Ecommercewebsite.model;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="category_id")
    private Long id;
    @NotNull
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
