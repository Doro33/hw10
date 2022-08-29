package online_shop.view.start_menu;

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
                    AppContext.getSignIn().logIn();
                    break;
                case "2":
                    System.out.println("----------------");
                    AppContext.getSignUp().signUpNewClient();
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