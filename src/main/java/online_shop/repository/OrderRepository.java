package online_shop.repository;

import online_shop.entity.order.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderRepository {
    void createTable() throws SQLException;

    Order addOrder(Order order) throws SQLException;

    Order setTotalPrice(int orderId) throws SQLException;

    Order findById(int id) throws SQLException;

    ArrayList<Order> getClientOrders(int clientId) throws SQLException;
}