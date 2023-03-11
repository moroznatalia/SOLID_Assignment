package ro.ase.cts.classes;

import ro.ase.cts.interfaces.ITableCreatorService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator implements ITableCreatorService {
    public static final String DROP_SQL_STATEMENT;
    public static final String CREATE_SQL_STATEMENT;
    static{
        DROP_SQL_STATEMENT = "DROP TABLE IF EXISTS employees";
        CREATE_SQL_STATEMENT = "CREATE TABLE employees(id INTEGER PRIMARY KEY,\"\n" +
                "                + \"name TEXT, address TEXT, salary REAL)";
    }

    @Override
    public void createTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(DROP_SQL_STATEMENT);
        statement.executeUpdate(CREATE_SQL_STATEMENT);
        statement.close();
        connection.commit();
    }
}
