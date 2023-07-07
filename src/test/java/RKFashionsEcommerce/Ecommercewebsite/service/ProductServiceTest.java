package RKFashionsEcommerce.Ecommercewebsite.service;
        import RKFashionsEcommerce.Ecommercewebsite.model.Product;
        import RKFashionsEcommerce.Ecommercewebsite.repository.ProductRepository;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.MockitoAnnotations;

        import java.util.ArrayList;
        import java.util.List;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        // Arrange
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product(1L, "Product 1", null, "Description 1", 10.0, "image1.jpg", 5));
        expectedProducts.add(new Product(2L, "Product 2", null, "Description 2", 20.0, "image2.jpg", 10));

        when(productRepository.findAll()).thenReturn(expectedProducts);

        // Act
        List<Product> actualProducts = productService.getAllProducts();

        // Assert
        assertEquals(expectedProducts.size(), actualProducts.size());
        assertEquals(expectedProducts.get(0), actualProducts.get(0));
        assertEquals(expectedProducts.get(1), actualProducts.get(1));
    }
}
