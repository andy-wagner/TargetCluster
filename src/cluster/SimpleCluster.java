package cluster;

import source.DataSource;
import target.Target;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author EuiJin.Ham
 * @version 1.0.0
 * @description A Class for clustering the text-based data simply
 * @param <T> The Java Type for mapping ClusteringRaw instance
 */
public abstract class SimpleCluster<T> extends Cluster<T> {

    public SimpleCluster(Target target, List<DataSource> dataSources){
        super(target, dataSources);
    }

    public SimpleCluster(Target target, DataSource dataSource){
        super(target, dataSource);
    }

    @Override
    public void make() {
        if(this.clusteringRawMap == null) this.clusteringRawMap = new ConcurrentHashMap<>();
        final List<String> mergedList = DataSource.mergeAsList(this.dataSources);

        for(String datum : mergedList){
            // TODO
        }

    }

    @Override
    public T take(String category, String detail) {
        return map(getData(category, detail));
    }

}
