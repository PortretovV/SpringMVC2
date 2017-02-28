package portvitaly.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Dao {
    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    private  DataSource dataSource;
    protected Connection connection;

    public Dao() {
    }

    public Connection openConnection() throws SQLException, NamingException {
        connection = dataSource.getConnection();
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null)
            connection.close();
    }
}