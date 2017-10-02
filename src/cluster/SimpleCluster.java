package cluster;

import source.DataSource;
import target.Target;

/**
 * @author EuiJin.Ham
 * @version 1.0.0
 * @description A Class for clustering the text-based data simply
 * @param <T> The Java Type for mapping ClusteringRaw instance
 */
public abstract class SimpleCluster<T> extends Cluster<T> {

    public SimpleCluster(Target target, DataSource dataSource){
        super(target, dataSource);

    }

    @Override
    public void make() {

    }

    @Override
    public abstract T map(ClusteringRaw raw, T toMake);

    @Override
    public T take(String category, String detail) {
        return null;
    }

}
