package source;

import java.io.IOException;

/**
 * @author EuiJin.Ham
 * @version 1.0.0
 * @description An Interface for designing A DataSource Model
 */
public interface IDataSource {

    /**
     * Collects the data cumulatively until the method named take called
     * @return The result of collecting job
     */
    boolean collect() throws IOException;

    /**
     * Returns the Collected data
     * @return Collected Data
     */
    String take() throws NullPointerException;

    /**
     * Flushes the collected data variable and resets the data input source
     * @return
     */
    void flush() throws NullPointerException;

}
