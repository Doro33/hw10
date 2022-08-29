package online_shop.view.start_menu;

import online_shop.entity.client.Client;
import online_shop.util.AppContext;

public class SignIn {
    private String setUsername(){
        String input;
        while (true){
            System.out.print("username: ");
            input= AppContext.getScanner().nextLine();
            if(input.matches("0")) {
                System.out.println("----------------");
                AppContext.getStarterMenu().startMenu();
                break;
            }if(!AppContext.getSignInService().usernameExist(input))
                System.out.println("this username is not correct.");
            else
                break;
        }
        return input;
    }
    public  Client logIn(){
        System.out.println("sign in:");
        System.out.println("0) back.");
        String username= setUsername();
        String truePassword=AppContext.getSignInService().findClientByUsername(username).getPassword();
        String inputPassword;
        while (true){
            System.out.print("password: ");
            inputPassword=AppContext.getScanner().nextLine();
            if(inputPassword.matches("0")){
                System.out.println("----------------");
                AppContext.getStarterMenu().startMenu();
                break;
            }
            if (!inputPassword.equals(truePassword))
                System.out.println("this password is incorrect.");
            else
                return AppContext.getSignInService().findClientByUsername(username);
        }
        return null;
    }
}
