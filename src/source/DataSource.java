package source;

import java.util.List;
import java.util.Vector;

/**
 * @author EuiJin.Ham
 * @version 1.0.0
 * @description An Abstract class for designing A DataSource Model and declaration
 */
public abstract class DataSource implements IDataSource{

    public static final String DELIMITER_DEFAULT = "\r\n";

    /**
     * The collected data
     */
    protected StringBuffer source;

    private String currentDelimiter = DELIMITER_DEFAULT;

    public void appendToSource(String newData) throws NullPointerException{
        appendToSource(newData, DELIMITER_DEFAULT);
    }

    public void appendToSource(String newData, String delimiter) throws NullPointerException{
        this.currentDelimiter = delimiter;
        this.source.append(newData + this.currentDelimiter);
    }

    public String getCurrentDelimiter() {
        return currentDelimiter;
    }

    @Override
    public DataSource flush() throws NullPointerException {
        this.source.setLength(0);
        return this;
    }

    public static List<String> mergeAsList(List<DataSource> dataSources){
        List<String> list = new Vector<>();
        for(DataSource s : dataSources) list.add(s.take());
        return list;
    }

}
