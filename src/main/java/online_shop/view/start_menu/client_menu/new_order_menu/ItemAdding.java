package online_shop.view.start_menu.client_menu.new_order_menu;

import online_shop.entity.products.ElectricDevice;
import online_shop.entity.products.Product;
import online_shop.entity.products.Readable;
import online_shop.entity.products.Shoes;
import online_shop.exceptions.InvalidNumberException;
import online_shop.util.AppContext;

import java.util.ArrayList;

public class ItemAdding {
    private ArrayList<ElectricDevice> showElectricDevices(){
        return AppContext.getOrderMenuService().getElectricDevices();
    }
    private ArrayList<Shoes> showShoes(){
        return AppContext.getOrderMenuService().getShoes();
    }
    public Product chooseReadable(){
        ArrayList<Readable> readableProducts= AppContext.getOrderMenuService().getReadable();
        System.out.println("0) back");
        AppContext.printStrings(readableProducts);
        System.out.println("which one do you want?");
        String input=AppContext.getScanner().nextLine();
        if(input.equals("0")){
            System.out.println("should be fixed");
        }else try{
            return readableProducts.get(Integer.parseInt(input)-1);
        }catch (Exception e){
        }
        return null;
    }
}
