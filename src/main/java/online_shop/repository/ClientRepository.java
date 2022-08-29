package online_shop.repository;

import online_shop.entity.client.Client;

import java.sql.SQLException;

public interface ClientRepository {
    void createTable() throws SQLException;

    Client addClient(Client client) throws SQLException;

    Client findByUsername(String username) throws SQLException;

    boolean usernameExist(String username) throws SQLException;
    boolean nationalCodeExist(String nationalCode) throws SQLException;
}