package cluster;

import source.DataSource;
import target.Target;

/**
 * @author EuiJin.Ham
 * @version 1.0.0
 * @description A Class for clustering the text-based data (Abstract)
 * @param <T> The Java Type for mapping ClusteringRaw instance
 */
public abstract class Cluster<T> implements ICluster<T>{

    /**
     * Target Instance
     */
    protected Target target;
    /**
     * DataSource instance
     */
    protected DataSource dataSource;

    /**
     * Default Constructor
     * @deprecated
     */
    @Deprecated
    public Cluster(){
    }

    /**
     * Simple Constructor
     * @param target target instance
     * @param dataSource datasource instance
     */
    public Cluster(Target target, DataSource dataSource){
        this.target = target;
        this.dataSource = dataSource;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
