package ro.ase.cts.classes;

import ro.ase.cts.interfaces.IDataInserterService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataInserterWithParams implements IDataInserterService {
    public static final String INSERT_WITH_PARAMS_SQL_STATEMENT;
    static{
        INSERT_WITH_PARAMS_SQL_STATEMENT = "INSERT INTO employees VALUES (?,?,?,?)";
    }

    @Override
    public void insertData(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WITH_PARAMS_SQL_STATEMENT);
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, "Ionescu Vasile");
        preparedStatement.setString(3, "Brasov");
        preparedStatement.setDouble(4, 4500);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.commit();
    }
}
