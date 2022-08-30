package online_shop.view.start_menu.client_menu;

import online_shop.entity.client.Client;
import online_shop.util.AppContext;

public class ClientExit {
    public void exitCheck(Client client){
        System.out.println("are you sure you want to exit?");
        String input;
        while (true) {
            System.out.print("y as yes / n as no : ");
            input = AppContext.getScanner().nextLine().toLowerCase();
            if (input.matches("y")) {
                System.out.println("----------------");
                AppContext.getStarterMenu().startMenu();
            } else if (input.matches("n")) {
                System.out.println("----------------");
                AppContext.getClientMenu().startMenu(client);
            } else
                System.out.println("your input is not valid.");
        }
    }
}