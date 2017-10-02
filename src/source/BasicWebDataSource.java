package source;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author EuiJin.Ham
 * @version 1.0.0
 * @description A Class for collecting data from web site data source
 */
public class BasicWebDataSource extends DataSource {

    private String url;
    private String selector;

    public BasicWebDataSource(String url, String selector){
        this.url = url;
        this.selector = selector;
    }

    /**
     * An Overrode method for explicitly calling a collection order
     * @return Success flag
     * @throws IOException
     */
    @Override
    public DataSource collect() throws IOException {
        if(source == null) source = new StringBuffer();

        final Document doc = Jsoup.connect(url).get();
        final Elements contents = doc.select(selector);

        for(Element e : contents) {
            appendToSource(e.text());
        }

        return this;
    }

    /**
     * A method for retrieving data from collection
     * @return taken data from collected data
     * @throws NullPointerException
     */
    @Override
    public String take() throws NullPointerException {
        if(source == null) throw new NullPointerException();

        return source.toString().trim();
    }

    /**
     * A Method for initializing the collected buffer
     * @throws NullPointerException
     */
    @Override
    public DataSource flush() throws NullPointerException {
        source.setLength(0);
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }
}
