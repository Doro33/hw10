package online_shop.util;

import online_shop.repository.ClientRepository;
import online_shop.repository.OrderRepository;
import online_shop.repository.clientRepositoryImpl.ClientRepoImpl;
import online_shop.repository.orderRepositoryImpl.OrderRepoImpl;
import online_shop.repository.productRepositoryImpl.ElectricDeviceRepoImpl;
import online_shop.repository.productRepositoryImpl.ReadableRepoImpl;
import online_shop.repository.productRepositoryImpl.ShoesRepoImpl;
import online_shop.sevice.client_menu_service.PreviousOrderService;
import online_shop.sevice.order_menu_service.OrderMenuService;
import online_shop.sevice.starter_menu_service.SignInService;
import online_shop.sevice.starter_menu_service.SignUpService;
import online_shop.view.start_menu.client_menu.ClientExit;
import online_shop.view.start_menu.client_menu.ClientMenu;
import online_shop.view.start_menu.client_menu.PreviousOrders;
import online_shop.view.start_menu.client_menu.new_order_menu.ItemAdding;
import online_shop.view.start_menu.client_menu.new_order_menu.NewOrderMenu;
import online_shop.view.start_menu.client_menu.new_order_menu.OrderExit;
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
    private static final ElectricDeviceRepoImpl ELECTRIC_DEVICE_REPO= new ElectricDeviceRepoImpl();
    private static final ShoesRepoImpl SHOES_REPO= new ShoesRepoImpl();
    private static final ReadableRepoImpl READABLE_REPO= new ReadableRepoImpl();
    private static final OrderMenuService ORDER_MENU_SERVICE= new OrderMenuService();
    private static final ItemAdding ITEM_ADDING= new ItemAdding();
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
    public static ElectricDeviceRepoImpl getElectricDeviceRepo(){return ELECTRIC_DEVICE_REPO;}
    public static ShoesRepoImpl getShoesRepo(){return SHOES_REPO;}
    public static ReadableRepoImpl getReadableRepo(){return READABLE_REPO;}
    public static OrderMenuService getOrderMenuService(){return ORDER_MENU_SERVICE;}
    public static ItemAdding getItemAdding(){return ITEM_ADDING;}
    public static void printStrings(ArrayList input) {
        if (input.isEmpty())
            System.out.println("there is no item to show.");
        else
            for (int i = 0; i < input.size(); i++) {
                System.out.println(i + 1 + ") " + input.get(i));
            }
    }
    public static void doneReaction() {
        System.out.println("Done.");
        System.out.println("Press Enter To Continue");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }
    }
}