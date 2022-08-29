package online_shop.repository.clientRepositoryImpl;

import online_shop.entity.client.Client;
import online_shop.repository.ClientRepository;
import online_shop.util.AppConnection;

import java.sql.*;

public class ClientRepoImpl implements ClientRepository {
    private Connection connection = AppConnection.getConnection();
    @Override
    public void createTable() throws SQLException {
        String sql = """
                create table if not exists client(
                id serial primary key,
                name varchar(32),
                national_code varchar(32) unique,
                username varchar(32) unique,
                password varchar(32)
                )
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.execute();
    }

    @Override
    public Client addClient(Client client) throws SQLException {
        String sql = """
                INSERT INTO client (name,national_code,username,password)
                VALUES (?,?,?,?)
                """;

        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,client.getName());
        ps.setString(2,client.getNationalCode());
        ps.setString(3,client.getUsername());
        ps.setString(4,client.getPassword());

        ps.execute();
        ResultSet generatedIds = ps.getGeneratedKeys();
        generatedIds.next();
        int id = generatedIds.getInt(1);
        client.setId(id);
        ps.close();
        generatedIds.close();
        return client;
    }

    @Override
    public Client findByUsername(String username) throws SQLException {
        String sql = """
                Select * from client
                where username=?;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, username);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
        Client output=new Client();
        output.setId(rs.getInt(1));
        output.setName(rs.getString(2));
        output.setNationalCode(rs.getString(3));
        output.setUsername(rs.getString(4));
        output.setPassword(rs.getString(5));
        ps.close();
        rs.close();
        return output;}
        else return null;
    }

    @Override
    public boolean usernameExist(String username) throws SQLException {
        String sql = """
                SELECT username from client
                WHERE username=? ;
                """;
        PreparedStatement ps = AppConnection.getConnection().prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    @Override
    public boolean nationalCodeExist(String nationalCode) throws SQLException {
        String sql = """
                SELECT national_code from client
                WHERE national_code=? ;
                """;
        PreparedStatement ps = AppConnection.getConnection().prepareStatement(sql);
        ps.setString(1, nationalCode);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
}
