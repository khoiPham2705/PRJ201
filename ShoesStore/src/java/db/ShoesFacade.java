package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShoesFacade {

    public List<Shoes> select() throws SQLException {
        List<Shoes> list = null;
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM Shoes");
        list = new ArrayList<>();
        while (rs.next()) {
            // Doc row hien tai vao doi tuong shoes
            Shoes shoes = new Shoes();
            shoes.setId(rs.getInt("id"));
            shoes.setName(rs.getString("name"));
            shoes.setBrand(rs.getString("brand"));
            shoes.setCategory(rs.getString("category"));
            shoes.setSize(rs.getString("size"));
            shoes.setPrice(rs.getInt("price"));
            shoes.setDiscount(rs.getDouble("discount"));
            // Them shoes vao list
            list.add(shoes);
        }
        // Close connection
        con.close();
        return list;
    }

    public List<Shoes> select(int page, int pageSize) throws SQLException {
        List<Shoes> list = null;
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Shoes ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

        stm.setInt(1, (page - 1) * pageSize);
        stm.setInt(2, pageSize);

        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            // Doc row hien tai vao doi tuong shoes
            Shoes shoes = new Shoes();
            shoes.setId(rs.getInt("id"));
            shoes.setName(rs.getString("name"));
            shoes.setBrand(rs.getString("brand"));
            shoes.setCategory(rs.getString("category"));
            shoes.setSize(rs.getString("size"));
            shoes.setPrice(rs.getInt("price"));
            shoes.setDiscount(rs.getDouble("discount"));
            // Them shoes vao list
            list.add(shoes);
        }
        // Close connection
        con.close();
        return list;
    }

    public Shoes select(int id) throws SQLException {
        Shoes shoes = null;
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Shoes WHERE id = ?");

        stm.setInt(1, id);

        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            // Doc row hien tai vao doi tuong shoes
            shoes = new Shoes();
            shoes.setId(rs.getInt("id"));
            shoes.setName(rs.getString("name"));
            shoes.setBrand(rs.getString("brand"));
            shoes.setCategory(rs.getString("category"));
            shoes.setSize(rs.getString("size"));
            shoes.setPrice(rs.getInt("price"));
            shoes.setDiscount(rs.getDouble("discount"));
        }
        // Close connection
        con.close();
        return shoes;
    }

    public int count() throws SQLException {

        int rowCount = 0;

        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT COUNT(*) AS [rowCount] FROM Shoes");
        if (rs.next()) {
            rowCount = rs.getInt("rowCount");
        }
        // Close connection
        con.close();
        return rowCount;
    }

    public int create(Shoes shoes) throws SQLException {
        Connection con = DBContext.getConnection();
        // Insert into db
        String sql = "INSERT INTO shoes(name, brand, category, size, price, discount) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement stm = con.prepareStatement(sql);

        stm.setString(1, shoes.getName());
        stm.setString(2, shoes.getBrand());
        stm.setString(3, shoes.getCategory());
        stm.setString(4, shoes.getSize());
        stm.setInt(5, shoes.getPrice());
        stm.setDouble(6, shoes.getDiscount());
        stm.executeUpdate();

        // Getting the inserted shoes's id
        Statement stm2 = con.createStatement();
        ResultSet rs = stm2.executeQuery("SELECT IDENT_CURRENT('Shoes') AS LastInsertedID;");

        int lastId = 0;

        if (rs.next()) {
            lastId = rs.getInt("LastInsertedID");
        }

        con.close();
        return lastId;
    }

    public void delete(int id) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("DELETE from shoes WHERE id = ?");
        // Cung cap gia tri cho cac tham so
        stm.setInt(1, id);

        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }

    public Shoes read(int id) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("SELECT * FROM shoes WHERE id = ?");
        // Cung cap gia tri cho cac tham so
        stm.setInt(1, id);

        // Thuc hien lenh SQL
        ResultSet rs = stm.executeQuery();
        Shoes shoes = new Shoes();

        while (rs.next()) {
            // Doc row hien tai vao doi tuong shoes
            shoes.setId(rs.getInt("id"));
            shoes.setName(rs.getString("name"));
            shoes.setBrand(rs.getString("brand"));
            shoes.setCategory(rs.getString("category"));
            shoes.setSize(rs.getString("size"));
            shoes.setPrice(rs.getInt("price"));
            shoes.setDiscount(rs.getDouble("discount"));
        }

        // Close connection
        con.close();
        return shoes;
    }

    public void update(Shoes shoes) throws SQLException {
        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va chuan bi cau lenh SQL
        PreparedStatement stm = con.prepareStatement("UPDATE Shoes SET Name=?, Brand=?, Category=?, Size=?, Price=?, Discount=? WHERE id=?");
        // Cung cap gia tri cho cac tham so
        stm.setString(1, shoes.getName());
        stm.setString(2, shoes.getBrand());
        stm.setString(3, shoes.getCategory());
        stm.setString(4, shoes.getSize());
        stm.setInt(5, shoes.getPrice());
        stm.setDouble(6, shoes.getDiscount());
        stm.setInt(7, shoes.getId());
        // Thuc hien lenh SQL
        int count = stm.executeUpdate();

        // Close connection
        con.close();
    }

    public Shoes getById(int id) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT * FROM shoes WHERE id=?");
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();

        Shoes shoes = null;
        if (rs.next()) {
            shoes = new Shoes(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("brand"),
                    rs.getString("category"),
                    rs.getString("size"), // Thêm size vào
                    rs.getInt("price"),
                    rs.getDouble("discount")
            );
        }
        con.close();
        return shoes;
    }

    public List<Shoes> getByBrand(String brand, int page, int pageSize) throws SQLException {
        List<Shoes> shoesList = new ArrayList<>();
        String sql = "SELECT * FROM Shoes WHERE brand = ? ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try (Connection con = DBContext.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, brand);
            stmt.setInt(2, (page - 1) * pageSize);
            stmt.setInt(3, pageSize);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Shoes shoe = new Shoes();
                shoe.setId(rs.getInt("id"));
                shoe.setName(rs.getString("name"));
                shoe.setBrand(rs.getString("brand"));
                shoe.setCategory(rs.getString("category"));
                shoe.setPrice(rs.getInt("price"));
                shoe.setDiscount(rs.getDouble("discount"));
                shoesList.add(shoe);
            }
        }
        return shoesList;
    }

    public int countByBrand(String brand) throws SQLException {

        int rowCount = 0;

        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        PreparedStatement stm = con.prepareStatement("SELECT COUNT(*) AS [rowCount] FROM Shoes WHERE brand = ?");

        stm.setString(1, brand);

        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            rowCount = rs.getInt("rowCount");
        }
        // Close connection
        con.close();
        return rowCount;
    }

    public List<Shoes> getByPrice(String order, int min_price, int max_price, int page, int pageSize) throws SQLException {
        List<Shoes> shoesList = new ArrayList<>();
        String sql = "SELECT * FROM Shoes WHERE price * (1 - discount) >= ? AND price * (1 - discount) <= ? ORDER BY price * (1 - discount) " + order + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try (Connection con = DBContext.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, min_price);
            stmt.setInt(2, max_price);
            stmt.setInt(3, (page - 1) * pageSize);
            stmt.setInt(4, pageSize);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Shoes shoe = new Shoes();
                shoe.setId(rs.getInt("id"));
                shoe.setName(rs.getString("name"));
                shoe.setBrand(rs.getString("brand"));
                shoe.setCategory(rs.getString("category"));
                shoe.setPrice(rs.getInt("price"));
                shoe.setDiscount(rs.getDouble("discount"));
                shoesList.add(shoe);
            }
        }
        return shoesList;
    }

    public int countByPrice(int min_price, int max_price) throws SQLException {

        int rowCount = 0;

        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        PreparedStatement stm = con.prepareStatement("SELECT COUNT(*) AS [rowCount] FROM Shoes WHERE price - (price * discount) >= ? AND price - (price * discount) <= ?");

        stm.setInt(1, min_price);
        stm.setInt(2, max_price);

        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            rowCount = rs.getInt("rowCount");
        }
        // Close connection
        con.close();
        return rowCount;
    }

    public List<Shoes> searchByKeyword(String keyword, int page, int pageSize) throws SQLException {
        List<Shoes> list = new ArrayList<>();

        String sql = "SELECT * FROM Shoes WHERE name LIKE ? OR brand LIKE ? ORDER BY name OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try (Connection con = DBContext.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            stmt.setInt(3, (page - 1) * pageSize);
            stmt.setInt(4, pageSize);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Shoes shoe = new Shoes(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getString("category"),
                        rs.getString("size"),
                        rs.getInt("price"),
                        rs.getDouble("discount")
                );
                list.add(shoe);
            }
        }
        return list;
    }

    public int countBySearch(String keyword) throws SQLException {

        int rowCount = 0;

        //Tao connection
        Connection con = DBContext.getConnection();
        // Tao doi tuong stm va thuc hien lenh SELECT
        PreparedStatement stm = con.prepareStatement("SELECT COUNT(*) AS [rowCount] FROM Shoes WHERE name LIKE ? OR brand LIKE ?");

        stm.setString(1, "%" + keyword + "%");
        stm.setString(2, "%" + keyword + "%");

        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            rowCount = rs.getInt("rowCount");
        }
        // Close connection
        con.close();
        return rowCount;
    }

}
