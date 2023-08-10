package dev.cubric.shopping_mall.Service;

import dev.cubric.shopping_mall.Entity.CartItem;
import dev.cubric.shopping_mall.Entity.Product;
import dev.cubric.shopping_mall.Repository.CartItemRepository;
import dev.cubric.shopping_mall.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public CartItem addToCart(Long productId, int quantity) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItem.setPrice(product.getPrice() * quantity);
            cartItemRepository.save(cartItem);
            return cartItem;
        }
        return null;
    }

    public void removeFromCart(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public Iterable<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }
}
