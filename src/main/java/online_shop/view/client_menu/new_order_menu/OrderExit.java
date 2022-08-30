package online_shop.view.client_menu.new_order_menu;

import online_shop.entity.client.Client;
import online_shop.util.AppContext;

public class OrderExit {
    public void exitCheck(Client client){
        System.out.println("WARNING: your order wont save if you have not confirmed it.");
        System.out.println("are you sure you want to get back?");
        String input;
        while (true) {
            System.out.print("y as yes / n as no : ");
            input = AppContext.getScanner().nextLine().toLowerCase();
            if (input.matches("y")) {
                System.out.println("----------------");
                AppContext.getNewOrderMenu().setItems(null);
                AppContext.getClientMenu().startMenu(client);
            } else if (input.matches("n")) {
                System.out.println("----------------");
                AppContext.getNewOrderMenu().startMenu(client);
            } else
                System.out.println("your input is not valid.");
        }
    }
}
