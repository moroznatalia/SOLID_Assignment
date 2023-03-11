package ro.ase.cts.classes;

import ro.ase.cts.interfaces.IDataReaderService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataReader implements IDataReaderService {
    public static final String SELECT_SQL_STATEMENT;
    static {
        SELECT_SQL_STATEMENT = "SELECT * FROM employees";
    }

    @Override
    public ResultSet readData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(SELECT_SQL_STATEMENT);
    }
}
