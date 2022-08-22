package Chuong12_JDBC;

import java.sql.*;

public class UpdateDataExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            System.out.println("Connect database successful!");

            statement = con.prepareStatement("UPDATE STUDENT_HOADT SET NAME = ? WHERE ID = ?");
            statement.setString(1,"Nguyen Viet Hien") ;
            statement.setInt(2,2);
            statement.executeUpdate();

            System.out.println("success!");
        } finally {
            statement.close();
            con.close();
        }
    }
}
