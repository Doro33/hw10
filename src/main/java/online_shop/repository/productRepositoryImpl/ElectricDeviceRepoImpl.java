package online_shop.repository.productRepositoryImpl;

import online_shop.entity.products.ElectricDevice;
import online_shop.repository.ProductRepository;
import online_shop.util.AppConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ElectricDeviceRepoImpl implements ProductRepository<ElectricDevice> {

    Connection connection = AppConnection.getConnection();

    private ElectricDevice getElectricDevice(ResultSet rs) throws SQLException {
        ElectricDevice output = new ElectricDevice();
        output.setId(rs.getInt(1));
        output.setName(rs.getString(2));
        output.setCategory(rs.getString(3));
        output.setProducer(rs.getString(4));
        output.setSize(rs.getFloat(5));
        output.setQuantity(rs.getInt(6));
        output.setPrice(rs.getFloat(7));
        return output;
    }

    @Override
    public void createTable() throws SQLException {
        String sql = """
                create table if not exists electric_device(
                id serial primary key,
                name varchar(32),
                category varchar(32),
                producer varchar(32),
                size float,
                quantity integer,
                price float
                )
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.execute();
    }

    @Override
    public ElectricDevice findById(int id) throws SQLException {
        String sql = """
                Select * from electric_device
                where id=?;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        return getElectricDevice(rs);
    }

    @Override
    public ArrayList<ElectricDevice> getAvailableProducts() throws SQLException {
        String sql = """
                Select * from electric_device
                where quantity>0;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<ElectricDevice> output = new ArrayList<>();
        while (rs.next()) {
            output.add(getElectricDevice(rs));
        }
        rs.close();
        return output;
    }

    @Override
    public void updateQuantity(int id, int numberOfItem) throws SQLException {
        ElectricDevice ed = findById(id);
        String sql = """
                UPDATE electric_device
                SET quantity=?
                WHERE id = ?
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, ed.getQuantity() - numberOfItem);
        ps.setInt(2, id);
        ps.execute();
        ps.close();
    }
}