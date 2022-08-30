package online_shop.view.client_menu.new_order_menu;

import online_shop.entity.client.Client;
import online_shop.entity.order.Item;
import online_shop.util.AppContext;

import java.util.ArrayList;

public class NewOrderMenu {
    private ArrayList<Item> items = new ArrayList<>();
    private  ArrayList<String> menuItems = new ArrayList<>();
     {
        menuItems.add("add an item");
        menuItems.add("delete an item");
        menuItems.add("confirm my order");
        menuItems.add("get back");
    }
    public void startMenu(Client client){
        AppContext.printStrings(menuItems);
        System.out.print("what do you want to do: ");
        String input;
        while (true) {
            input=AppContext.getScanner().nextLine();
            switch (input) {
                case "1":
                    System.out.println("----------------");
                    break;
                case "2":
                    System.out.println("----------------");
                    break;
                case "3":
                    System.out.println("----------------");
                    break;
                    case "4":
                    System.out.println("----------------");
                    AppContext.getOrderExit().exitCheck(client);
                    break;
                default:
                    System.out.println("your input is not valid.");
                    System.out.print("you can only choose 1-4 : ");
            }
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
