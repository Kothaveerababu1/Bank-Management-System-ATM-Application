package bankmanagement;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            String username = System.getenv("DB_USERNAME");
            String password = System.getenv("DB_PASSWORD");

            c = DriverManager.getConnection(
                "jdbc:mysql:///bankmanagementsystem",
                username,
                password
            );

            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}