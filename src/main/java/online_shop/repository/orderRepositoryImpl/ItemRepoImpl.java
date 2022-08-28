package online_shop.repository.orderRepositoryImpl;

import online_shop.entity.order.Item;
import online_shop.repository.ItemRepository;
import online_shop.util.AppConnection;

import java.sql.*;
import java.util.ArrayList;

public class ItemRepoImpl implements ItemRepository {
    private Connection connection = AppConnection.getConnection();

    private Item getItem(ResultSet rs) throws SQLException {
        Item item = new Item();
        item.setId(rs.getInt(1));
        item.setOrderId(rs.getInt(2));
        item.setKind(rs.getString(3));
        item.setProductId(rs.getInt(4));
        item.setNumber(rs.getInt(5));
        item.setUnitPrice(rs.getFloat(6));
        item.setRetailPrice(rs.getFloat(7));
        return item;
    }

    @Override
    public void createTable() throws SQLException {

        String sql = """
                create table if not exists item(
                id serial primary key,
                order_id serial REFERENCES orders (id),
                kind varchar(32),
                product_id int,
                number int,
                unit_price float,
                retail_price float
                )
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.execute();
    }

    @Override
    public Item addItem(Item item) throws SQLException {
        String sql = """
                INSERT INTO item(order_id,kind,product_id,number,unit_price,retail_price)
                VALUES (?,?,?,?,?,?)
                """;

        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, item.getOrderId());
        ps.setString(2, item.getKind());
        ps.setInt(3, item.getProductId());
        ps.setInt(4, item.getNumber());
        ps.setFloat(5, item.getUnitPrice());
        ps.setFloat(6, item.getRetailPrice());

        ps.execute();
        ResultSet generatedIds = ps.getGeneratedKeys();
        generatedIds.next();
        int id = generatedIds.getInt(1);
        item.setId(id);
        ps.close();
        generatedIds.close();
        return item;
    }

    @Override
    public Item findById(int id) throws SQLException {
        String sql = """
                Select * from item
                where id=?;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        rs.next();
        Item output = getItem(rs);
        ps.close();
        rs.close();
        return output;
    }

    @Override
    public ArrayList<Item> findOrderItems(int orderId) throws SQLException {
        String sql = """
                Select * from item
                where order_id=?
                order by id;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, orderId);
        ResultSet rs = ps.executeQuery();
        ArrayList<Item> output = new ArrayList<>();
        while (rs.next()) {
            output.add(getItem(rs));
        }
        rs.close();
        return output;
    }
}