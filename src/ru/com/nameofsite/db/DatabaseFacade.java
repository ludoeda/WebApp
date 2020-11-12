package ru.com.nameofsite.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseFacade {

    public static List<String> getBooks() {
        List<String> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234")) {
            System.out.println("Java JDBC PostgreSQL Example");
            System.out.println("Connected to PostgreSQL");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from books.books");
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
        }
        catch (SQLException e) {
            System.out.println("Connection failure");
            e.printStackTrace();
        }
        return result;
    }
    public static void insert(String input) {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234")) {
            System.out.println("Java JDBC PostgreSQL Example");
            System.out.println("Connected to PostgreSQL");
            Statement st = con.createStatement();
            String sql = "insert into books.books (name) values ('" + input +"')";
            st.execute("insert into books.books (name) values ('" + input +"')");
        }
        catch (SQLException e) {
            System.out.println("Connection failure");
            e.printStackTrace();
        }
    }
}
