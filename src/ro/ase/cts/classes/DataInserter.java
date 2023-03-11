package ro.ase.cts.classes;

import ro.ase.cts.interfaces.IDataInserterService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataInserter implements IDataInserterService {
    public static final String INSERT_SQL_STATEMENT;
    static{
        INSERT_SQL_STATEMENT = "INSERT INTO employees VALUES(1, 'Popescu Ion', 'Bucharest', 4000)";
    }

    @Override
    public void insertData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(INSERT_SQL_STATEMENT);
        statement.close();
        connection.commit();
    }
}
