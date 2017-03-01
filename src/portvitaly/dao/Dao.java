package portvitaly.dao;

import org.springframework.beans.factory.annotation.Autowired;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Dao {


    @Autowired
    private  DataSource dataSource;
    protected Connection connection;

    public Dao() {
    }

    public DataSource getDataSource() {
        return dataSource;
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