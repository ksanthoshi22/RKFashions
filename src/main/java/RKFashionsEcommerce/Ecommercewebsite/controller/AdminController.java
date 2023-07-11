package RKFashionsEcommerce.Ecommercewebsite.controller;

import RKFashionsEcommerce.Ecommercewebsite.model.Category;
import RKFashionsEcommerce.Ecommercewebsite.repository.ProductRepository;
import RKFashionsEcommerce.Ecommercewebsite.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AdminController {

    // Autowire necessary dependencies
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductRepository productRepository;

    // Route for admin home page
    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    // Route to display all categories
    @GetMapping("/admin/categories")
    public String getCat(Model model){
        Category category= new Category();
        model.addAttribute("categories",categoryService.getAllCategory());
        return "categories";
    }
    // Route to display the form for adding a new category
    @GetMapping("/admin/categories/add")
    public String getCatAdd( Model model) {

        model.addAttribute("category", new Category());
        return "categoriesAdd";

    }
    // Handler for adding a new category
    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category, Model model) {
    if (categoryService.doesCategoryExist(category.getName())) {
        model.addAttribute("categoryExists", true);
        model.addAttribute("category", category);
        return "categoriesAdd";
    }
     categoryService.addCategory(category);
    return "redirect:/admin/categories";
    }

    // Handler for deleting a category
    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable long id) {
        if (productRepository.findAllByCategory_Id(id).isEmpty()) {
            categoryService.removeCategoryById(id);
            return "redirect:/admin/categories";
        }
        else {
            return "/failure";
        }
    }


    @GetMapping("/admin/categories/update/{id}")
    public String updateCategory(@PathVariable long id,Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        }
        else
            return "404";
    }
}
