package online_shop.repository;

import online_shop.entity.order.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemRepository {
    void createTable() throws SQLException;

    Item addItem(Item item) throws SQLException;

    Item findById(int id) throws SQLException;

    ArrayList<Item> findOrderItems(int orderId) throws SQLException;
}