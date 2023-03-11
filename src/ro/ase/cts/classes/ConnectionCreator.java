package ro.ase.cts.classes;

import ro.ase.cts.interfaces.IConnectionService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator implements IConnectionService {
    public static final String CLASS_NAME;
    public static final String CONNECTION_NAME;

    static {
        CLASS_NAME = "org.sqlite.JDBC";
        CONNECTION_NAME = "jdbc:sqlite:database.db";
    }

    @Override
    public Connection createConnection() throws SQLException, ClassNotFoundException {
        Class.forName(CLASS_NAME);
        Connection connection = DriverManager.getConnection(CONNECTION_NAME);
        connection.setAutoCommit(false);
        return connection;
    }
}

