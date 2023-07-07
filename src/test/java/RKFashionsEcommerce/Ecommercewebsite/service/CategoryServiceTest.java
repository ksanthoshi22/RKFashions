package RKFashionsEcommerce.Ecommercewebsite.service;

import RKFashionsEcommerce.Ecommercewebsite.model.Category;
import RKFashionsEcommerce.Ecommercewebsite.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;
    @Mock
    private CategoryRepository categoryRepository;


    @Test
    public void testGetAllCategory() {
        // Arrange
        Category category1 = new Category(1L, "Category 1");
        Category category2 = new Category(2L, "Category 2");
        List<Category> mockCategories = Arrays.asList(category1, category2);

        // Mock the behavior of the categoryRepository
        Mockito.when(categoryRepository.findAll()).thenReturn(mockCategories);

        // Act
        List<Category> categories = categoryService.getAllCategory();

        // Assert
        assertEquals(2, mockCategories.size());


    }


}
