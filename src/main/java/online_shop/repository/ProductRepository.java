package online_shop.repository;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductRepository<E> {
    void createTable() throws SQLException;

    E findById(int id) throws SQLException;

    ArrayList<E> getAvailableProducts() throws SQLException;

    void updateQuantity(int id, int numberOfItem) throws SQLException;
}