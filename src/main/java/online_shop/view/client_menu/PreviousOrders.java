package online_shop.view.client_menu;

import online_shop.entity.client.Client;
import online_shop.entity.order.Order;
import online_shop.util.AppContext;

import java.util.ArrayList;

public class PreviousOrders {
    public ArrayList<Order> clientPreviousOrders(Client client){
        int clientId=client.getId();
        ArrayList<Order> previousOrders=AppContext.getPreviousOrderService().clientPreviousOrders(clientId);
        AppContext.printStrings(previousOrders);
        System.out.println("press enter to get back.");
        try {
            System.in.read();
            System.out.println("----------------");
            AppContext.getClientMenu().startMenu(client);
        } catch (Exception ignored) {}
        return previousOrders;
    }
}
