package ro.ase.cts.classes;

import ro.ase.cts.interfaces.*;

import java.sql.Connection;
import java.sql.ResultSet;

public class Orchestrator {
    private IConnectionService connectionService;
    private ITableCreatorService tableCreatorService;
    private IDataInserterService dataInserterService;
    private IDataReaderService dataReaderService;
    private IDataWriterService dataWriterService;

    public Orchestrator(IConnectionService connectionService, ITableCreatorService tableCreatorService,
                        IDataInserterService dataInserterService, IDataReaderService dataReaderService,
                        IDataWriterService dataWriterService) {
        this.connectionService = connectionService;
        this.tableCreatorService = tableCreatorService;
        this.dataInserterService = dataInserterService;
        this.dataReaderService = dataReaderService;
        this.dataWriterService = dataWriterService;
    }

    public void setDataInserterService(IDataInserterService dataInserterService){
        this.dataInserterService = dataInserterService;
    }

    public void runWorkFlow() {
        try {
            Connection connection = connectionService.createConnection();
            tableCreatorService.createTable(connection);
            dataInserterService.insertData(connection);
            ResultSet resultSet = dataReaderService.readData(connection);
            dataWriterService.displayResult(resultSet);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
