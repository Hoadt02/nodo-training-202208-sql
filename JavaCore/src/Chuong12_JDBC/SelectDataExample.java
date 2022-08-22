package Chuong12_JDBC;

import java.sql.*;

public class SelectDataExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = null;
        Statement statement = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = con.createStatement();
            System.out.println("Connect database successful!");

            ResultSet rs = statement.executeQuery("SELECT * FROM STUDENT_HOADT");
            while (rs.next()){
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                int age = rs.getInt(3);

                System.out.println(id + "\t" + name + "\t" + age);
            }
        }finally {
            statement.close();
            con.close();
        }
    }
}
