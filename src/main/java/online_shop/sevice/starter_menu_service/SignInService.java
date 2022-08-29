package online_shop.sevice.starter_menu_service;

import online_shop.entity.client.Client;
import online_shop.util.AppContext;

import java.sql.SQLException;

public class SignInService {
    public boolean usernameExist(String username) {
        try {
            return AppContext.getClientRepository().usernameExist(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Client findClientByUsername(String username){
        try {
            return AppContext.getClientRepository().findByUsername(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
