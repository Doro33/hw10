package online_shop.sevice.client_menu_service;

import online_shop.entity.order.Order;
import online_shop.util.AppContext;

import java.sql.SQLException;
import java.util.ArrayList;

public class PreviousOrderService {
    public ArrayList<Order> clientPreviousOrders(int clientId){
        try {
            return AppContext.getOrderRepository().getClientOrders(clientId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}