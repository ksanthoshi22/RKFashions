package RKFashionsEcommerce.Ecommercewebsite.controller;

import RKFashionsEcommerce.Ecommercewebsite.service.CategoryService;
import RKFashionsEcommerce.Ecommercewebsite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String products(){

        return "products";
    }
    @GetMapping("/contact")
    public String contact(){

        return "contact";
    }
    // Check if the user is authenticated and determine if they are an admin
    @GetMapping({"/", "/home", "/index"})
    public String home(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("isAdmin", false);
        model.addAttribute("loggedIn", false);
        if (authentication != null && authentication.isAuthenticated() &&
                !authentication.getName().equals("anonymousUser")) {
            boolean isAdmin = authentication.getAuthorities().stream()
                    .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));
            model.addAttribute("isAdmin", isAdmin);
            model.addAttribute("loggedIn", true);
        }
        return "index";
    }
    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProducts());
        return "shop";
    }
    // Route to display the shop page with products filtered by category
    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable long id) {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProductsByCategoryId(id));
        return "shop";
    }
    // Route to display the details of a specific product
    @GetMapping("/shop/viewProduct/{id}")
    public String viewProduct(Model model, @PathVariable long id) {
        model.addAttribute("product", productService.getProductById(id).get());
        return "viewProduct";
    }
    @GetMapping("/logout")
    public String logout(){
        return "redirect:/home";
    }
}
