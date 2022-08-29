package online_shop.view.client_menu;

import online_shop.util.AppContext;

import java.util.ArrayList;

public class ClientMenu {
    private ArrayList<String> menuItems= new ArrayList<>();
     {
        menuItems.add("new order");
        menuItems.add("my previous orders");
        menuItems.add("exit");
    }
    public void startMenu(){
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
                    AppContext.getClientExit().exitCheck();
                    break;
                default:
                    System.out.println("your input is not valid.");
                    System.out.print("you can only choose 1-3 : ");
            }
        }
    }
}
