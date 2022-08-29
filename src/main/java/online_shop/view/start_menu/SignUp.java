package online_shop.view.start_menu;

import online_shop.entity.client.Client;
import online_shop.util.AppContext;

public class SignUp {
    private boolean lengthCheck(String input, int maxLength) {
        if (input.isEmpty()) {
            System.out.println("this field could not be empty.");
            return false;
        } else if (input.length() > maxLength) {
            System.out.println("this field cannot have more than " + maxLength + "characters.");
            return false;
        } else return true;
    }
    private String getString() {
        String input;
        while (true) {
            input = AppContext.getScanner().nextLine();
            if (input.matches("0")) {
                System.out.println("----------------");
                AppContext.getStarterMenu().startMenu();
            }
            if (lengthCheck(input, 32))
                return input;
        }
    }


    private String setName() {
        System.out.print("name: ");
        return getString();
    }
    private String setNationalCode() {
        System.out.print("national code: ");
        String nationalCode;
        while (true) {
            nationalCode = AppContext.getScanner().nextLine();
            if (nationalCode.matches("0")) {
                System.out.println("----------------");
                AppContext.getStarterMenu().startMenu();
            }
            if (lengthCheck(nationalCode, 10)) {
                if (!AppContext.getSignUpService().newNationalCodePermit(nationalCode))
                    System.out.println("this national code has already been taken.");
                else return nationalCode;
            }
        }
    }
    private String setUsername() {
        System.out.print("username: ");
        String username;
        while (true) {
            username = AppContext.getScanner().nextLine();
            if (username.matches("0")) {
                System.out.println("----------------");
                AppContext.getStarterMenu().startMenu();
            }
            if (lengthCheck(username, 32)) {
                if (!AppContext.getSignUpService().newUsernamePermit(username))
                    System.out.println("this username has already been taken.");
                else return username;
            }
        }
    }

    private String setPassword() {
        System.out.print("password: ");
        return getString();
    }
    private Client makeNewClient(){
        System.out.println("0) back.");
        Client newClient = new Client();
        newClient.setName(setName());
        newClient.setNationalCode(setNationalCode());
        newClient.setUsername(setUsername());
        newClient.setPassword(setPassword());
        return newClient;
    }
    public Client signUpNewClient(){
        System.out.println("sign up:");
        Client client= makeNewClient();
        return AppContext.getSignUpService().addNewClient(client);
    }
}