package edu.hanoi;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent> {

    private final static Logger LOGGER = Logger.getLogger(ContextStartEventHandler.class);
    @Autowired
    private DataSource dataSource;

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        LOGGER.info("context start application " + dataSource);
        try {
            createTable("HN_USER","create table HN_USER\n" +
                    "(\n" +
                    "\tusername varchar(100) primary key,\n" +
                    "    password varchar(100),\n" +
                    "    email varchar(100),\n" +
                    "    age int,\n" +
                    "    group_id int,\n" +
                    "\tconstraint GROUP_FK foreign key(group_id) references HN_GROUP(id)\n" +
                    ")");
        }catch (Exception e){
            LOGGER.error(e,e);
        }
    }

    private void createTable(String name, String script) throws SQLException{
        DatabaseMetaData dbms = dataSource.getConnection().getMetaData();
        ResultSet rs = dbms.getTables(null, null, name, null);
        if (rs.next()){
            LOGGER.info("Table " + rs.getString("TABLE_NAME") + " already exists !");
            return;
        }
        dataSource.getConnection().createStatement().executeUpdate(script);
        LOGGER.info("Create success!");
    }
}
