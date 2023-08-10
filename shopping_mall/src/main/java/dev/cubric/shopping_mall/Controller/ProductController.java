package dev.cubric.shopping_mall.Controller;

import dev.cubric.shopping_mall.Entity.Product;
import dev.cubric.shopping_mall.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String main(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("productList", productList);
        return "main";
    }

    @GetMapping("/product/detail/{id}")
    public String showProductDetail(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id);
        // 상품 정보를 모델에 추가
        model.addAttribute("product", product);

        return "product_detail";
    }

    @GetMapping("/add")
    public String showAddProductForm() {
        return "add_product";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("image") MultipartFile image,
                             @RequestParam("price") double price) {
        productService.addProduct(name, description, image, price);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/"; // 삭제 후 메인 페이지로 이동
    }
}
