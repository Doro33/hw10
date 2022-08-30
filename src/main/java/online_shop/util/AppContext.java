package online_shop.util;

import online_shop.repository.ClientRepository;
import online_shop.repository.OrderRepository;
import online_shop.repository.clientRepositoryImpl.ClientRepoImpl;
import online_shop.repository.orderRepositoryImpl.OrderRepoImpl;
import online_shop.sevice.client_menu_service.PreviousOrderService;
import online_shop.sevice.starter_menu_service.SignInService;
import online_shop.sevice.starter_menu_service.SignUpService;
import online_shop.view.client_menu.ClientExit;
import online_shop.view.client_menu.ClientMenu;
import online_shop.view.client_menu.PreviousOrders;
import online_shop.view.client_menu.new_order_menu.NewOrderMenu;
import online_shop.view.client_menu.new_order_menu.OrderExit;
import online_shop.view.start_menu.ExitProgram;
import online_shop.view.start_menu.SignIn;
import online_shop.view.start_menu.SignUp;
import online_shop.view.start_menu.StarterMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class AppContext {
    //private static final Scanner SCANNER = new Scanner(System.in);
    private static final StarterMenu STARTER_MENU = new StarterMenu();
    private static final ExitProgram EXIT_PROGRAM = new ExitProgram();
    private static final ClientRepository CLIENT_REPOSITORY= new ClientRepoImpl();
    private static final SignUpService SIGN_UP_SERVICE= new SignUpService();
    private static final SignUp SIGN_UP= new SignUp();
    private static final SignInService SIGN_IN_SERVICE=new SignInService();
    private static final SignIn SIGN_IN = new SignIn();
    private static final ClientMenu CLIENT_MENU = new ClientMenu();
    private static final ClientExit CLIENT_EXIT = new ClientExit();
    private static final OrderRepository ORDER_REPOSITORY= new OrderRepoImpl();
    private static final PreviousOrderService PREVIOUS_ORDER_SERVICE = new PreviousOrderService();
    private static final PreviousOrders PREVIOUS_ORDERS= new PreviousOrders();
    private static final NewOrderMenu NEW_ORDER_MENU = new NewOrderMenu();
    private static final OrderExit ORDER_EXIT=new OrderExit();
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
    public static StarterMenu getStarterMenu(){return STARTER_MENU;}
    public static ExitProgram getExitProgram(){return EXIT_PROGRAM;}
    public static ClientRepository getClientRepository(){return CLIENT_REPOSITORY;}
    public static SignUpService getSignUpService(){return SIGN_UP_SERVICE;}
    public static SignUp getSignUp(){return SIGN_UP;}
    public static SignInService getSignInService(){return SIGN_IN_SERVICE;}
    public static SignIn getSignIn(){return SIGN_IN;}
    public static ClientMenu getClientMenu(){return CLIENT_MENU;}
    public static ClientExit getClientExit(){return CLIENT_EXIT;}
    public static OrderRepository getOrderRepository(){return ORDER_REPOSITORY;}
    public static PreviousOrderService getPreviousOrderService(){return PREVIOUS_ORDER_SERVICE;}
    public static PreviousOrders getPreviousOrders(){return PREVIOUS_ORDERS;}
    public static NewOrderMenu getNewOrderMenu(){return NEW_ORDER_MENU;}
    public static OrderExit getOrderExit(){return ORDER_EXIT;}
    public static void printStrings(ArrayList input) {
        if (input.isEmpty())
            System.out.println("there is no item to show.");
        else
            for (int i = 0; i < input.size(); i++) {
                System.out.println(i + 1 + ") " + input.get(i));
            }
    }
}