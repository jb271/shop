package data;

import domain.entity.Bottom;
import domain.entity.Cupcake;
import domain.entity.Topping;
import domain.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public List<Bottom> getAllBottoms() {
        List<Bottom> list = new ArrayList<Bottom>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM bottoms;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                Bottom bottom = new Bottom(id, name, price);
                list.add(bottom);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Topping> getAllToppings() {
        List<Topping> list = new ArrayList<Topping>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM bottoms;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                Topping topping = new Topping(id, name, price);
                list.add(topping);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public Bottom getBottom(int id) {
        Bottom bottom = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM bottoms WHERE id=?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");
                bottom = new Bottom(id, name, price);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bottom;
    }

    public Topping getTopping(int id) {
        Topping topping = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM topings WHERE id=?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");
                topping = new Topping(id, name, price);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return topping;
    }

    public Cupcake getCupcake(int id) {
        Cupcake cupcake = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM cupcakes WHERE id=?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int topping = rs.getInt("topping");
                int bottom = rs.getInt("bottom");
                cupcake = new Cupcake(id, topping, bottom);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cupcake;
    }

    public User getUser(int id) {
        User user = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT name, password, balance FROM customers "
                    + "WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");
                int balance = rs.getInt("balance");
                user = new User(id, name, password, balance);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public User getUser(String name) {
        User user = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT id, password, balance FROM customers "
                    + "WHERE name=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");
                int balance = rs.getInt("balance");
                user = new User(id, name, password, balance);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    public void addUser(User user) {
        try {
            Connection conn = new DB().getConnection();
            String sql = "INSERT INTO customers (name, password, balance) "
                    + "VALUES (?, ?, ?);";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3, user.getBalance());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            Connection conn = new DB().getConnection();
            String sql = "UPDATE customers SET name=?, password=?, balance=? "
                    + "WHERE id=?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3, user.getBalance());
            pstmt.setInt(4, user.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
