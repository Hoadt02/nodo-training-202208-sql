package Chuong12_JDBC;

import java.sql.*;

public class JdbcFirstExample {
    static Connection con = null;
    static Statement statement = null;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       create();
    }


    private static void create() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = con.createStatement();
            System.out.println("Connect database successful!");

            String sql = "CREATE TABLE STUDENT_HOADT2\n" +
                    "(ID NUMBER(2) NOT NULL CONSTRAINT PK_STUDENT_TEST_HOADT PRIMARY KEY, NAME VARCHAR2(50), AGE  NUMBER(2))";
            boolean resul = statement.execute(sql);
            System.out.println(resul);

            String sql2 = "CREATE SEQUENCE SEQ_STUDENT_HOADT2 INCREMENT BY 1 START WITH 1 NOCYCLE";
            System.out.println(statement.execute(sql2));

        } finally {
            statement.close();
            con.close();
        }
    }
}
