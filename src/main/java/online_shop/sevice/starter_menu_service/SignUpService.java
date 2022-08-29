package online_shop.sevice.starter_menu_service;

import online_shop.entity.client.Client;
import online_shop.util.AppContext;

import java.sql.SQLException;

public class SignUpService {
    public boolean newUsernamePermit(String username) {
        boolean output = false;
        try {
            if (!AppContext.getClientRepository().usernameExist(username))
                output = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }
    public boolean newNationalCodePermit(String nationalCode) {
        boolean output = false;
        try {
            if (!AppContext.getClientRepository().nationalCodeExist(nationalCode))
                output = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }
    public Client addNewClient(Client client){
        try {
            return AppContext.getClientRepository().addClient(client);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}