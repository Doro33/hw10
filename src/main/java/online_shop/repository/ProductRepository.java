package online_shop.repository;

import online_shop.entity.products.Product;

import java.util.ArrayList;

public interface ProductRepository<E> {
    void createTable();
    E getOne(int id);
    ArrayList<E> getAvailableP();
    void updateQuantity(int id, int numberOfItem);
}
