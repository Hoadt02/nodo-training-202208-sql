package Chuong12_JDBC;

import java.sql.*;

public class TransactionExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            System.out.println("Connect database successful!");

            con.setAutoCommit(false);
            for (int i = 0; i < 10; i++) {
                String name = "Tran Van " + i;
                int age = 10 + i;
                statement = con.prepareStatement("INSERT INTO STUDENT_HOADT(ID,NAME,AGE) VALUES (SEQ_STUDENT_HOADT2.NEXTVAL,?,?)");
                statement.setString(1,name);
                statement.setInt(2, age);
                statement.executeUpdate();
            }
            con.rollback();
            con.setAutoCommit(true);
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM STUDENT_HOADT");
            if (rs.next()) System.out.println("total records = " + rs.getInt(1));

            System.out.println("success!");
        } finally {
            statement.close();
            con.close();
        }
    }
}
