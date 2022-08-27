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
    public Client findById(int id) throws SQLException {
        String sql = """
                Select * from client
                where id=?;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        rs.next();
        Client output=new Client();
        output.setId(id);
        output.setName(rs.getString(2));
        output.setNationalCode(rs.getString(3));
        output.setUsername(rs.getString(4));
        output.setPassword(rs.getString(5));
        ps.close();
        rs.close();
        return output;
    }
}
