package RKFashionsEcommerce.Ecommercewebsite.repository;

import RKFashionsEcommerce.Ecommercewebsite.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    private Category mockCategory;

    @BeforeEach
    public void setup() {
        mockCategory = setMockCategory();
    }

    private Category setMockCategory() {
        Long id = 1L;
        String name = "Bangles";
        return new Category(id, name);
    }

    @Test
    public void testFindByName_ExistingCategory_ReturnsCategory() {
        // Arrange
        String name = "Bangles";

        // Act
        Optional<Category> foundCategoryOptional = categoryRepository.findByName(name);

        // Assert
        assertTrue(foundCategoryOptional.isPresent());
        Category foundCategory = foundCategoryOptional.get();
        assertTrue(foundCategory.getName().equalsIgnoreCase(name));
    }
}