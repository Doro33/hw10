package online_shop.repository.productRepositoryImpl;

import online_shop.entity.products.Shoes;
import online_shop.repository.ProductRepository;
import online_shop.util.AppConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShoesRepoImpl implements ProductRepository<Shoes> {
    private Connection connection = AppConnection.getConnection();

    private Shoes getShoes(ResultSet rs) throws SQLException {
        Shoes output = new Shoes();
        output.setId(rs.getInt(1));
        output.setName(rs.getString(2));
        output.setCategory(rs.getString(3));
        output.setProducer(rs.getString(4));
        output.setSize(rs.getFloat(5));
        output.setColor(rs.getString(6));
        output.setQuantity(rs.getInt(7));
        output.setPrice(rs.getFloat(8));
        return output;
    }

    @Override
    public void createTable() throws SQLException {
        String sql = """
                create table if not exists shoes(
                id serial primary key,
                name varchar(32),
                category varchar(32),
                producer varchar(32),
                size float,
                color varchar(32),
                quantity integer,
                price float
                )
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.execute();
    }

    @Override
    public Shoes findById(int id) throws SQLException {
        String sql = """
                Select * from shoes
                where id=?;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        return getShoes(rs);
    }

    @Override
    public ArrayList<Shoes> getAvailableProducts() throws SQLException {
        String sql = """
                Select * from shoes
                where quantity>0;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Shoes> output = new ArrayList<>();
        while (rs.next()) {
            output.add(getShoes(rs));
        }
        rs.close();
        return output;
    }

    @Override
    public void updateQuantity(int id, int numberOfItem) throws SQLException {
        Shoes shoes = findById(id);
        String sql = """
                UPDATE shoes
                SET quantity=?
                WHERE id = ?
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, shoes.getQuantity() - numberOfItem);
        ps.setInt(2, id);
        ps.execute();
        ps.close();
    }
}