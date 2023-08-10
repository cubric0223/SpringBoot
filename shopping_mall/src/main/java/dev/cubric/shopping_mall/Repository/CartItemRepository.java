package dev.cubric.shopping_mall.Repository;

import dev.cubric.shopping_mall.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
