package online_shop.sevice.order_menu_service;

import online_shop.entity.products.ElectricDevice;
import online_shop.entity.products.Product;
import online_shop.entity.products.Readable;
import online_shop.entity.products.Shoes;
import online_shop.util.AppContext;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderMenuService {
    public ArrayList<ElectricDevice> getElectricDevices(){
        try {
            return AppContext.getElectricDeviceRepo().getAvailableProducts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Shoes> getShoes(){
        try {
            return AppContext.getShoesRepo().getAvailableProducts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Readable> getReadable(){
        try {
            return AppContext.getReadableRepo().getAvailableProducts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
