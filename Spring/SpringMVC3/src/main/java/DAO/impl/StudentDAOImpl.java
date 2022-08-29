package DAO.impl;

import DAO.StudentDAO;
import model.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class StudentDAOImpl implements StudentDAO, DisposableBean {

    private static final Logger LOGGER = Logger.getLogger(StudentDAOImpl.class);

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @Autowired
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

    @Override
    public void insert(Student student) {
        jdbcTemplate.update("insert into student(name, age) values (?,?)", student.getName(), student.getAge());
        LOGGER.info("Created Record Name = " + student.getName());
    }

    // SHUTDOWN DERBY
    @Override
    public void destroy() throws Exception {
        DriverManager.getConnection("jdbc:mysql://localhost:3306/dotathoa;shutdown=true");
    }

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

    @Override
    public List<Student> list() {
       return jdbcTemplate.query("select * from student", new StudentRowMapper());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.execute("delete from student where id = " + id);
    }

    @Override
    public Student get(Integer id) {
        return jdbcTemplate.queryForObject("select * from student where id = " + id, new StudentRowMapper());
    }

    @Override
    public void update(Student student) {
        jdbcTemplate.update("update student set name = ?, age = ? where id = ?", student.getName(),student.getAge(),student.getId());
    }

    @Override
    public List<Student> search(String name) {
       return jdbcTemplate.query("select * from student where name = '" + name + "'", new StudentRowMapper());
    }
}

