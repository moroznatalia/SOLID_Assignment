package ro.ase.cts.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionService {
    Connection createConnection() throws SQLException, ClassNotFoundException;
}
