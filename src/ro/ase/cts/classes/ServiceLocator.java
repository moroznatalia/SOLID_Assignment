package ro.ase.cts.classes;

import ro.ase.cts.interfaces.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {
    private Map<Type, Object> map = new HashMap<>();

    public ServiceLocator(){
        map.put(IConnectionService.class, new ConnectionCreator());
        map.put(ITableCreatorService.class, new TableCreator());
        map.put(IDataInserterService.class, new DataInserter());
        map.put(IDataReaderService.class, new DataReader());
        map.put(IDataWriterService.class, new SystemOutDataWriter());
    }

    public <T> T get(Type contract){
        return (T)map.get(contract);
    }
}
