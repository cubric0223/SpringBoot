package dev.cubric.shopping_mall.Repository;

import dev.cubric.shopping_mall.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
