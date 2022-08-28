package online_shop.repository.orderRepositoryImpl;

import online_shop.entity.order.Order;
import online_shop.repository.OrderRepository;
import online_shop.util.AppConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderRepoImpl implements OrderRepository {
    private Connection connection = AppConnection.getConnection();

    private Order getOrder(ResultSet rs) throws SQLException {
        Order output = new Order();
        output.setId(rs.getInt(1));
        output.setClientId(rs.getInt(2));
        output.setAddressId(rs.getInt(3));
        output.setOrderDate(rs.getDate(4));
        output.setTotalPrice(rs.getFloat(5));
        output.setStatus(rs.getString(6));
        return output;
    }

    @Override
    public void createTable() throws SQLException {
        String sql = """
                create table if not exists orders(
                id serial primary key,
                client_id serial REFERENCES client (id),
                address_id int,
                order_date date,
                total_price float,
                status varchar(32)
                )
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.execute();
    }

    @Override
    public Order addOrder(Order order) throws SQLException {
        String sql = """
                INSERT INTO orders (client_id,address_id,order_date)
                VALUES (?,?,?)
                """;

        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, order.getClientId());
        ps.setInt(2, order.getAddressId());
        ps.setDate(3, Date.valueOf(LocalDate.now()));

        ps.execute();
        ResultSet generatedIds = ps.getGeneratedKeys();
        generatedIds.next();
        int id = generatedIds.getInt(1);
        order.setId(id);
        order.setOrderDate(generatedIds.getDate(4));
        ps.close();
        generatedIds.close();
        return order;
    }

    @Override
    public Order setTotalPrice(int orderId) {
        return null;
    }

    @Override
    public Order findById(int id) throws SQLException {
        String sql = """
                Select * from orders
                where id=?;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        rs.next();
        Order output = getOrder(rs);
        ps.close();
        rs.close();
        return output;
    }


    @Override
    public ArrayList<Order> getClientOrders(int clientId) throws SQLException {
        String sql = """
                Select * from orders
                where client_id=?
                order by id;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, clientId);
        ResultSet rs = ps.executeQuery();
        ArrayList<Order> output = new ArrayList<>();
        while (rs.next()) {
            output.add(getOrder(rs));
        }
        rs.close();
        return output;
    }
}