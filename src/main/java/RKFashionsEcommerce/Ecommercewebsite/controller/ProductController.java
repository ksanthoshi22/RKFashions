package RKFashionsEcommerce.Ecommercewebsite.controller;

import RKFashionsEcommerce.Ecommercewebsite.dto.ProductDTO;
import RKFashionsEcommerce.Ecommercewebsite.model.Product;
import RKFashionsEcommerce.Ecommercewebsite.service.CategoryService;
import RKFashionsEcommerce.Ecommercewebsite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
@Controller
public class ProductController {
      //public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";
      public String uploadDir = "src/main/resources/static/productImages";
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/admin/products")
    public String getProducts(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "showProducts";
    }
    @GetMapping("/sProducts")
    public String getSProductsPage() {
        return "sProducts";
    }
    @GetMapping("/admin/products/add")
    public String productAddGet(Model model){
        model.addAttribute("productDTO",new ProductDTO());
        model.addAttribute("categories",categoryService.getAllCategory());
        return "productsAdd";
    }
    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("productDto")ProductDTO productDTO,
                                 @RequestParam("productImage") MultipartFile file,
                                 @RequestParam("imgName") String imgName) throws IOException

    {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setQuantity(productDTO.getQuantity());
        String imageUUID ;
        if(!file.isEmpty()){
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir,imageUUID);
            Files.write(fileNameAndPath,file.getBytes());
        }
        else{
            imageUUID = imgName;
        }
        product.setImageName(imageUUID);
        productService.addProduct(product);
        return"redirect:/admin/products";
    }
    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable long id) {

      productService.removeProductById(id);
            return "redirect:/admin/products";
        }

    @GetMapping("/admin/product/update/{id}")
        public String updateProduct(@PathVariable long id,Model model){
        Product product = productService.getProductById(id).get();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setImageName(product.getImageName());
        productDTO.setQuantity(product.getQuantity());
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("productDTO",productDTO);
        return "productsAdd";
    }

}
