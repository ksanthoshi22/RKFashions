package RKFashionsEcommerce.Ecommercewebsite.service;

import RKFashionsEcommerce.Ecommercewebsite.model.Category;
import RKFashionsEcommerce.Ecommercewebsite.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    public void addCategory(Category category){
        categoryRepository.save(category);
    }
    public void removeCategoryById(long id) {
        categoryRepository.deleteById(id);
    }
    public Optional<Category> getCategoryById(long id){
        return categoryRepository.findById(id);
    }
    public boolean doesCategoryExist(String name) {
        Optional<Category> existingCategory = categoryRepository.findByName(name);
        return existingCategory.isPresent();
    }
}
