package online_shop.sevice.starter_menu_service;

import online_shop.util.AppContext;

import java.sql.SQLException;

public class SignUpService {
    public boolean newUsername(String username) {
        boolean output = false;
        try {
            if (!AppContext.getClientRepository().usernameExist(username))
                output = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }
}