package online_shop.repository;

import online_shop.entity.order.Order;

import java.util.ArrayList;

public interface OrderRepository {
    void createTable();

    Order addOrder(Order order);

    Order findById(int id);

    ArrayList<Order> clientOrders(int clientId);
}