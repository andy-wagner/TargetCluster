package cluster;

public interface ICluster<T> {

    void make();

    T map(ClusteringRaw raw);

    T take(String category, String detail);

}
