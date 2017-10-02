package cluster;

import source.DataSource;
import target.Target;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author EuiJin.Ham
 * @version 1.0.0
 * @description A Class for clustering the text-based data (Abstract)
 * @param <T> The Java Type for mapping ClusteringRaw instance
 */
public abstract class Cluster<T> implements ICluster<T>{

    protected ConcurrentHashMap<String, ClusteringRaw> clusteringRawMap;
    /**
     * Target Instance
     */
    protected Target target;
    /**
     * DataSource instance
     */
    protected List<DataSource> dataSources;

    /**
     * Default Constructor
     * @deprecated
     */
    @Deprecated
    public Cluster(){
        clusteringRawMap = new ConcurrentHashMap<>();
    }

    /**
     * Simple Constructor
     * @param target target instance
     * @param dataSources datasource instances
     */
    public Cluster(Target target, List<DataSource> dataSources){
        this();
        this.target = target;
        this.dataSources = dataSources;
    }

    public Cluster(Target target, DataSource dataSource){
        this();
        this.target = target;
        this.dataSources = new Vector<>();
        this.dataSources.add(dataSource);
    }

    protected static String generateCategoryKey(String category, String detail){
        return String.format("%s-[CLUSTER_KEY]-$s", category, detail);
    }

    public Iterator<String> iteratorForData(){
        return this.clusteringRawMap.keySet().iterator();
    }

    public ClusteringRaw putData(String category, String detail, ClusteringRaw raw){
        return this.clusteringRawMap.put(generateCategoryKey(category, detail), raw);
    }

    public ClusteringRaw getData(String category, String detail){
        return this.clusteringRawMap.get(generateCategoryKey(category, detail));
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public List<DataSource> getDataSources() {
        return dataSources;
    }

    public void setDataSource(List<DataSource> dataSources) {
        this.dataSources = dataSources;
    }

}
