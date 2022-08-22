package Chuong12_JDBC;

import java.sql.*;

public class BatchProcessingExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = con.prepareStatement("INSERT INTO STUDENT_HOADT(ID,NAME,AGE) VALUES (SEQ_STUDENT_HOADT2.NEXTVAL,?,?)");
            System.out.println("Connect database successful!");

            for (int i = 0; i < 20; i++) {
                String name = "Do Tat Hoa " + i;
                int age = 10 + i;
                statement.setString(1,name);
                statement.setInt(2, age);
                statement.addBatch();
            }
            statement.executeBatch();

            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM STUDENT_HOADT");
            if (rs.next()) System.out.println("total records = " + rs.getInt(1));
            System.out.println("success!");
        } finally {
            statement.close();
            con.close();
        }
    }
}
