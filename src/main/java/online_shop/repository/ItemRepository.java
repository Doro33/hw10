package online_shop.repository;

import online_shop.entity.order.Item;

import java.util.ArrayList;

public interface ItemRepository {
    void createTable();

    Item addItem(Item item);

    Item findById(int id);

    ArrayList<Item> findOrderItems(int orderId);
}