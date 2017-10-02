package cluster;

import java.util.Map;

/**
 * @author EuiJin.Ham
 * @version 1.0.0
 * @description A Class for storing entire Clustered data
 */
public class ClusteringRaw {

    private Map<String, Integer> counter;

    public ClusteringRaw(){}

    public Map<String, Integer> getCounter() {
        return counter;
    }

    public void setCounter(Map<String, Integer> counter) {
        this.counter = counter;
    }
}
