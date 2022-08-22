package Chuong12_JDBC;

import java.sql.*;

public class DbFunction {
    static Connection con = null;
    static Statement statement = null;

    public static void main(String[] args) throws SQLException {
        int[] ages = new int[1];
        getAge("DO T",ages);
        System.out.println(ages[0]);
    }

    public static void getAge(String name, int[] ages) throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT MAX(AGE) FROM STUDENT_HOADT WHERE NAME LIKE '%" + name + "%'");
            ages[0] = rs.next() ? rs.getInt(1):-1;
        }finally {
            statement.close();
            con.close();
        }
    }
}
