package online_shop.view.start_menu.client_menu.new_order_menu;

import online_shop.entity.client.Client;
import online_shop.entity.order.Item;
import online_shop.util.AppContext;

import java.util.ArrayList;

public class NewOrderMenu {
    private ArrayList<Item> items = new ArrayList<>();
    private final ArrayList<String> MENU_ITEMS = new ArrayList<>();
     {
        MENU_ITEMS.add("add an item");
        MENU_ITEMS.add("delete an item");
        MENU_ITEMS.add("confirm my order");
        MENU_ITEMS.add("get back");
    }
    public void StartMenu(Client client){
        AppContext.printStrings(MENU_ITEMS);
        System.out.print("what do you want to do: ");
        String input;
        while (true) {
            input=AppContext.getScanner().nextLine();
            switch (input) {
                case "1":
                    addAnItem(client);
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

    private void addAnItem(Client client) {
        if (items.size()<5){
        System.out.println("----------------");
        Item item =AppContext.getItemAdding().selectItem();
        items.add(item);
        AppContext.doneReaction();
        System.out.println("----------------");
        StartMenu(client);
        }else {
            System.out.println("order cant have more than 5 items.");
            AppContext.printStrings(items);
            StartMenu(client);
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
