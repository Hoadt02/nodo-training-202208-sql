package Chuong12_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataExample {
    static Connection con = null;
    static Statement statement = null;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        insert();
    }

    private static void insert() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = con.createStatement();
            System.out.println("Connect database successful!");

            statement.execute("INSERT INTO STUDENT_HOADT VALUES (SEQ_STUDENT_HOADT2.NEXTVAL,'DO TAT HOA',20)");
            statement.execute("INSERT INTO STUDENT_HOADT VALUES (SEQ_STUDENT_HOADT2.NEXTVAL,'DO TAT HOA',16)");
            statement.execute("INSERT INTO STUDENT_HOADT VALUES (SEQ_STUDENT_HOADT2.NEXTVAL,'DO TAT HOA',10)");

            System.out.println("success!");
        } finally {
            statement.close();
            con.close();
        }
    }
}
