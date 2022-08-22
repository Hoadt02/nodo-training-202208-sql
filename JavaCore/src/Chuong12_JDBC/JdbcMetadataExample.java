package Chuong12_JDBC;

import java.sql.*;

public class JdbcMetadataExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            DatabaseMetaData metaData = con.getMetaData();
            System.out.println("Connect database successful!");

            System.out.println("db version " + metaData.getDatabaseProductVersion());
            System.out.println("driver name: " + metaData.getDriverName());
        } finally {
            con.close();
        }
    }
}
