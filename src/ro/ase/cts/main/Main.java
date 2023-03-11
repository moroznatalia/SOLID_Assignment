package ro.ase.cts.main;

import ro.ase.cts.classes.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {
            Connection connection = new ConnectionCreator().createConnection();


            new TableCreator().createTable(connection);
            new DataInserter().insertData(connection);
            new DataInserterWithParams().insertData(connection);
            ResultSet resultSet = new DataReader().readData(connection);
            new SystemOutDataWriter().displayResult(resultSet);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}