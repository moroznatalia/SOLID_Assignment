package ro.ase.cts.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDataInserterService {
    void insertData(Connection connection) throws SQLException;
}
