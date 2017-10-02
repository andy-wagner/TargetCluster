package source;

import java.io.IOException;

public class SimpleDataSource extends DataSource {

    private String data;

    public SimpleDataSource(String staticString){
        this.source.append(staticString);
        this.data = staticString;
    }

    @Override
    public DataSource collect() throws IOException {
        this.source.append(data);
        return this;
    }

    @Override
    public String take() throws NullPointerException {
        return this.source.toString().trim();
    }

    @Override
    public DataSource flush() throws NullPointerException {
        return super.flush();
    }

}
