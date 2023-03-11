package ro.ase.cts.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDataWriterService {
    void displayResult(ResultSet resultSet) throws SQLException;
}
