package online_shop.view.start_menu;

import online_shop.util.AppContext;

public class ExitChecking {
    public void exitCheck(){
        System.out.println("are you sure you want to exit?");
        System.out.print("y as yes / n as no: ");
        String input;
        while (true) {
            input = AppContext.getScanner().nextLine().toLowerCase();
            if (input.matches("y")) {
                System.out.println("good bye.");
                System.out.println("----------------");
                System.exit(0);
            } else if (input.matches("n")) {
                System.out.println("----------------");
                AppContext.getStarterMenu().startMenu();
            } else {
                System.out.println("your input is not valid.");
                System.out.print("y as yes / n as no : ");
            }
        }
    }
}