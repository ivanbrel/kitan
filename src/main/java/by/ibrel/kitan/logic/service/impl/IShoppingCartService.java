package by.ibrel.kitan.logic.service.impl;


import by.ibrel.kitan.logic.dao.entity.ShoppingCart;


import java.util.List;

public interface IShoppingCartService {

    ShoppingCart createCart(Long clientId);

    List<ShoppingCart> allCart();

    void sellProduct(ShoppingCart shoppingCart, Integer count) throws Exception;

    void delete(Long id);

    ShoppingCart getCartById(Long id);

    void changeStatus(Long id);

    void editCart(ShoppingCart shoppingCart);

    void deleteProductFromCart(Long cartId, Long histId, Long productId);
}
