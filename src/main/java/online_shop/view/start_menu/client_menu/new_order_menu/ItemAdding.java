package online_shop.view.start_menu.client_menu.new_order_menu;

import online_shop.entity.order.Item;
import online_shop.entity.products.ElectricDevice;
import online_shop.entity.products.Product;
import online_shop.entity.products.Readable;
import online_shop.entity.products.Shoes;
import online_shop.util.AppContext;
import online_shop.view.start_menu.client_menu.ClientMenu;

import java.util.ArrayList;

public class ItemAdding {
    private final ArrayList<String> MENU_ITEMS= new ArrayList<>();
    {
        MENU_ITEMS.add("electric device");
        MENU_ITEMS.add("shoes");
        MENU_ITEMS.add("readable");
        MENU_ITEMS.add("exit");
    }
    private int getNumber(int maxRowIndex) {
        String input;
        int number;
        while (true) {
            input=AppContext.getScanner().nextLine();
            if(input.equals("0")){
                System.out.println("should be fixed");
            }else try{
                number=Integer.parseInt(input);
                if (0 < number && number<= maxRowIndex)
                    break;
                else System.out.println("your input is not valid");
            }catch (Exception e){
                System.out.println("your input is not valid");
            }
        }
        return number;
    }
    private void setKind(Product product, Item newItem) {
        if (product instanceof ElectricDevice)
            newItem.setKind("electric device");
        else if(product instanceof Shoes)
            newItem.setKind("shoes");
        else if (product instanceof Readable)
            newItem.setKind("readable");
    }
    private Product chooseElectricDevice(){
        ArrayList<ElectricDevice> electricDevices = AppContext.getOrderMenuService().getElectricDevices();
        System.out.println("0) back");
        AppContext.printStrings(electricDevices);
        System.out.print("which one do you want? ");
        int number = getNumber(electricDevices.size())-1;
        return electricDevices.get(number);
    }
    private Product chooseShoes(){
        ArrayList<Shoes> shoesProducts=AppContext.getOrderMenuService().getShoes();
        System.out.println("0) back");
        AppContext.printStrings(shoesProducts);
        System.out.print("which one do you want? ");
        int number = getNumber(shoesProducts.size())-1;
        return shoesProducts.get(number);
    }
    private Product chooseReadable(){
        ArrayList<Readable> readableProducts= AppContext.getOrderMenuService().getReadable();
        System.out.println("0) back");
        AppContext.printStrings(readableProducts);
        System.out.print("which one do you want? ");
        int number = getNumber(readableProducts.size())-1;
        return readableProducts.get(number);
    }

    private Item makeNewItem(Product product) {
        System.out.println(product);
        Item item = new Item();
        setKind(product, item);
        item.setProductId(product.getId());
        item.setUnitPrice(product.getPrice());
        System.out.println("we have "+ product.getQuantity()+" of this.");
        System.out.print("how many do you need?");
        int number = getNumber(product.getQuantity());
        item.setNumber(number);
        item.setRetailPrice(number*product.getPrice());
        return item;
    }

    public Item selectItem(){
        AppContext.printStrings(MENU_ITEMS);
        System.out.print("what do you want to do: ");
        String input;
        while (true) {
            input=AppContext.getScanner().nextLine();
            switch (input) {
                case "1":
                    System.out.println("----------------");
                    Product productE=chooseElectricDevice();
                    return makeNewItem(productE);
                case "2":
                    System.out.println("----------------");
                    Product productS=chooseShoes();
                    return makeNewItem(productS);
                case "3":
                    System.out.println("----------------");
                    Product productR=chooseReadable();
                    return makeNewItem(productR);
                case "4":
                    System.out.println("----------------");
                    AppContext.getNewOrderMenu().startMenu(AppContext.getClientMenu().getClient());
                    break;
                default:
                    System.out.println("your input is not valid.");
                    System.out.print("you can only choose 1-4 : ");
            }
        }
    }
}