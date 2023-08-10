package dev.cubric.shopping_mall.Service;

import dev.cubric.shopping_mall.Entity.Product;
import dev.cubric.shopping_mall.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private static String UPLOAD_DIR = "src/main/resources/static/images/";

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(String name, String description, MultipartFile image, double price) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price); // Set the price

        try {
            Path path = Paths.get(UPLOAD_DIR + image.getOriginalFilename());
            Files.write(path, image.getBytes());
            product.setImageName(image.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productRepository.save(product);
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
