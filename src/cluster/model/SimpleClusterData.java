package cluster.model;

import cluster.ClusteringRaw;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EuiJin.Ham
 * @version 1.0.0
 * @description A Class for storing the simple result of clustering process
 */
public class SimpleClusterData {

    private Map<String, Integer> count;

    /**
     * Default Constructor
     */
    public SimpleClusterData(){
        count = new HashMap<>();
    }

    /**
     * Constructor for mapping ClusteringRaw as SimpleClusterData
     * @param raw Clustered raw data
     */
    public SimpleClusterData(ClusteringRaw raw){
        this.count = new HashMap<>();
        this.count.putAll(raw.getCounter());
    }

}
