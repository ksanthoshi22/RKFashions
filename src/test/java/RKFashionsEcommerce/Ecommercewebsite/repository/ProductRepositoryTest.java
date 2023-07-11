package RKFashionsEcommerce.Ecommercewebsite.repository;
import RKFashionsEcommerce.Ecommercewebsite.model.Product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindAllByCategory_Id() {
        // Arrange
        long categoryId = 1L;

        // Act
        List<Product> products = productRepository.findAllByCategory_Id(categoryId);

        // Assert
        assertEquals(1, products.size());
        assertNotNull(products.get(0));


    }
}

