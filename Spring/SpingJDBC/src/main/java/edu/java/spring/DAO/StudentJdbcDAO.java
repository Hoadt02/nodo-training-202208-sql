package edu.java.spring.DAO;

import edu.java.spring.model.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentJdbcDAO {
    private static final Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class);

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private void createTableIfNotExist() throws SQLException {
        DatabaseMetaData dbms = dataSource.getConnection().getMetaData();
        ResultSet rs = dbms.getTables(null, null, "STUDENT", null);
        if (rs.next()) {
            LOGGER.info("Table " + rs.getString("TABLE_NAME") + " already exists");
            return;
        }

        jdbcTemplate.execute("create table student\n" +
                "(\n" +
                "\tid int auto_increment not null primary key,\n" +
                "    name nvarchar(100),\n" +
                "    age int\n" +
                ")");

    }

    //INSERT DATA

    private String insertQuery;

    public void insert(String name, int age) {
        jdbcTemplate.update(insertQuery, name, age);
        LOGGER.info("Create Record Name = " + name + " Age = " + age);
    }

    public void setInsertQuery(String insertQuery) {
        this.insertQuery = insertQuery;
    }

    // LOAD DATA - 1

    public int totalRecord() {
//        return jdbcTemplate.execute(new StatementCallback<Integer>() {
//            @Override
//            public Integer doInStatement(Statement statement) throws SQLException, DataAccessException {
//                ResultSet rs = statement.executeQuery("select count(*) from student");
//                return rs.next() ? rs.getInt(1) : 0;
//            }
//        });

        return jdbcTemplate.execute((Statement statement) -> {
            ResultSet rs = statement.executeQuery("select count(*) from student");
            return rs.next() ? rs.getInt(1) : 0;
        });
    }


    // LOAD DATA - 2

    private final class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int i) throws SQLException {
            try {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                return student;
            } catch (Exception e) {
                LOGGER.error(e,e);
                return null;
            }
        }
    }

    public List<Student> loadStudent(String name) {
        return jdbcTemplate.query(
                "select  * from student where name like '%" + name + "%'", new StudentRowMapper());
    }

    // UPDATE DATA

    private String updateAgeByNameSQL = "update student set age = ? where name = ?";

    public void updateAgeByName(String name, int age){
        jdbcTemplate.update(updateAgeByNameSQL, age, name);
    }

    public void deleteStudent(int id){
        jdbcTemplate.update("delete from student where id = ?",id);
    }

    // BATCH PROCESSING (Xử lý hàng loạt)

    public int[] add(List<Student> students){
        List<Object[]> bathch = new ArrayList<>();
        students.forEach(student -> {
            bathch.add(new Object[]{student.getName(), student.getAge()});
        });
        return jdbcTemplate.batchUpdate(insertQuery, bathch);
    }

    // TRANSACTION 3 - PROGRAMATIC

    @Autowired
    private PlatformTransactionManager transactionManager;

    public StudentJdbcDAO(){
        transactionManager = new PlatformTransactionManager() {
            @Override
            public TransactionStatus getTransaction(TransactionDefinition transactionDefinition) throws TransactionException {
                return null;
            }

            @Override
            public void commit(TransactionStatus transactionStatus) throws TransactionException {

            }

            @Override
            public void rollback(TransactionStatus transactionStatus) throws TransactionException {

            }
        };
    }

    public void save(String name, int age){
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        String countQuery = "SELECT COUNT(*) FROM STUDENT";
        Integer total;
        try {
            total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("before save, total record is " + total);

            String sql = "insert into student(name,age) values(?,?)";
            jdbcTemplate.update(sql,name,age);

            total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("after save data, total record is " + total);

            String countQuery2 = "select count(*) from student";
            total = jdbcTemplate.queryForObject(countQuery2, Integer.class);

            transactionManager.commit(status);
        }catch (Exception e){
            transactionManager.rollback(status);

            total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("after rollback, total record is " + total);
        }
    }
}
