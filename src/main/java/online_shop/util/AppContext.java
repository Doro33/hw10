package online_shop.util;

import online_shop.repository.ClientRepository;
import online_shop.repository.clientRepositoryImpl.ClientRepoImpl;
import online_shop.sevice.starter_menu_service.SignInService;
import online_shop.sevice.starter_menu_service.SignUpService;
import online_shop.view.start_menu.ExitChecking;
import online_shop.view.start_menu.SignIn;
import online_shop.view.start_menu.SignUp;
import online_shop.view.start_menu.StarterMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class AppContext {
    //private static final Scanner SCANNER = new Scanner(System.in);
    private static final StarterMenu STARTER_MENU = new StarterMenu();
    private static final ExitChecking EXIT_CHECKING= new ExitChecking();
    private static final ClientRepository CLIENT_REPOSITORY= new ClientRepoImpl();
    private static final SignUpService SIGN_UP_SERVICE= new SignUpService();
    private static final SignUp SIGN_UP= new SignUp();
    private static final SignInService SIGN_IN_SERVICE=new SignInService();
    private static final SignIn SIGN_IN = new SignIn();

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
    public static StarterMenu getStarterMenu(){return STARTER_MENU;}
    public static ExitChecking getExitChecking(){return EXIT_CHECKING;}
    public static ClientRepository getClientRepository(){return CLIENT_REPOSITORY;}
    public static SignUpService getSignUpService(){return SIGN_UP_SERVICE;}
    public static SignUp getSignUp(){return SIGN_UP;}
    public static SignInService getSignInService(){return SIGN_IN_SERVICE;}
    public static SignIn getSignIn(){return SIGN_IN;}
    public static void printStrings(ArrayList input) {
        if (input.isEmpty())
            System.out.println("there is no item to show.");
        else
            for (int i = 0; i < input.size(); i++) {
                System.out.println(i + 1 + ") " + input.get(i));
            }
    }
}