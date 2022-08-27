package online_shop.repository;

import online_shop.entity.client.Client;

import java.sql.SQLException;

public interface ClientRepository {
    void createTable() throws SQLException;

    Client addUser(Client client) throws SQLException;

    Client findById(int id) throws SQLException;
}