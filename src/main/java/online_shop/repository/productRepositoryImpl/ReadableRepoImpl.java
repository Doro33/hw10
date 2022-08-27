package online_shop.repository.productRepositoryImpl;

import online_shop.entity.products.Readable;
import online_shop.repository.ProductRepository;
import online_shop.util.AppConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadableRepoImpl implements ProductRepository<Readable> {
    private Connection connection = AppConnection.getConnection();

    private Readable getReadable(ResultSet rs) throws SQLException {
        Readable output = new Readable();
        output.setId(rs.getInt(1));
        output.setName(rs.getString(2));
        output.setCategory(rs.getString(3));
        output.setProducer(rs.getString(4));
        output.setWriter(rs.getString(5));
        output.setSubject(rs.getString(6));
        output.setQuantity(rs.getInt(7));
        output.setPrice(rs.getFloat(8));
        return output;
    }

    @Override
    public void createTable() throws SQLException {
        String sql = """
                create table if not exists readable(
                id serial primary key,
                name varchar(32),
                category varchar(32),
                producer varchar(32),
                writer varchar(32),
                subject varchar(32),
                quantity integer,
                price float
                )
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.execute();
    }

    @Override
    public Readable findById(int id) throws SQLException {
        String sql = """
                Select * from readable
                where id=?;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        return getReadable(rs);
    }

    @Override
    public ArrayList<Readable> getAvailableProducts() throws SQLException {
        String sql = """
                Select * from readable
                where quantity>0;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Readable> output = new ArrayList<>();
        while (rs.next()) {
            output.add(getReadable(rs));
        }
        rs.close();
        return output;
    }

    @Override
    public void updateQuantity(int id, int numberOfItem) throws SQLException {
        Readable readable = findById(id);
        String sql = """
                UPDATE readable
                SET quantity=?
                WHERE id = ?
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, readable.getQuantity() - numberOfItem);
        ps.setInt(2, id);
        ps.execute();
        ps.close();
    }
}