package online_shop.view.start_menu;

import online_shop.entity.client.Client;
import online_shop.util.AppContext;

import java.util.ArrayList;

public class StarterMenu {
    private ArrayList<String> menuItems= new ArrayList<>();
    {
        menuItems.add("sign in");
        menuItems.add("sign up");
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
                    Client client=AppContext.getSignIn().logIn();
                    System.out.println("----------------");
                    AppContext.getClientMenu().startMenu(client);
                    break;
                case "2":
                    System.out.println("----------------");
                    Client newClient=AppContext.getSignUp().signUpNewClient();
                    System.out.println("----------------");
                    AppContext.getClientMenu().startMenu(newClient);
                    break;
                case "3":
                    System.out.println("----------------");
                    AppContext.getExitProgram().exitCheck();
                    break;
                default:
                    System.out.println("your input is not valid.");
                    System.out.print("you can only choose 1-3 : ");
            }
        }
    }
}