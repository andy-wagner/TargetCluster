package source;

import java.io.IOException;

/**
 * @author EuiJin.Ham
 * @version 1.0.0
 * @description A Class for collecting data from web site data source
 */
public class WebDataSource extends DataSource {

    @Override
    public boolean collect() throws IOException {
        if(source == null) source = new StringBuffer();
        return false;
    }

    @Override
    public String take() throws NullPointerException {
        if(source == null) throw new NullPointerException();
        return null;
    }

    @Override
    public void flush() throws NullPointerException {
        source.setLength(0);
    }

}
