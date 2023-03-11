package ro.ase.cts.main;

import ro.ase.cts.classes.*;
import ro.ase.cts.interfaces.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        ServiceLocator serviceLocator = new ServiceLocator();
        Orchestrator orchestrator = new Orchestrator(serviceLocator.get(IConnectionService.class),
                serviceLocator.get(ITableCreatorService.class), serviceLocator.get(IDataInserterService.class),
                serviceLocator.get(IDataReaderService.class), serviceLocator.get(IDataWriterService.class));
        orchestrator.runWorkFlow();
        orchestrator.setDataInserterService(new DataInserterWithParams());
        orchestrator.runWorkFlow();
    }
}