package RKFashionsEcommerce.Ecommercewebsite.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private Long categoryId;
    private String description;
    private double price;
    private String imageName;
    private int quantity;
}
