package online_shop.view.start_menu;

import online_shop.util.AppContext;

public class SignUp {
    public static boolean lengthCheck(String input, int maxLength) {
        if (input.isEmpty()) {
            System.out.println("this field could not be empty.");
            return false;
        } else if (input.length() > maxLength) {
            System.out.println("this field cannot have more than " + maxLength + "characters.");
            return false;
        } else return true;
    }


    public static String setName() {
        System.out.print("name: ");
        String name;
        while (true) {
            name = AppContext.getScanner().nextLine();
            if (name.matches("0")) {
                System.out.println("----------------");
                AppContext.getStarterMenu().startMenu();
            }
            if (lengthCheck(name, 32))
                return name;
        }
    }
    /*public static String setName(){
        System.out.print("name: ");
        String name;
        do {
            name=AppContext.getScanner().nextLine();
        }while (!lengthCheck(name,32));
        return name;
    }*/


    public static String setUsername() {
        System.out.print("username: ");
        String username;
        while (true) {
            username = AppContext.getScanner().nextLine();
            if (username.matches("0")) {
                System.out.println("----------------");
                AppContext.getStarterMenu().startMenu();
            }
            if (lengthCheck(username, 32)) {
                if (!AppContext.getSignUpService().newUsername(username))
                    System.out.println("this username has already been taken.");
                else return username;
            }
        }
    }
}
