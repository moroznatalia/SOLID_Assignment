package ro.ase.cts.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface ITableCreatorService {
    void createTable(Connection connection) throws SQLException;
}
