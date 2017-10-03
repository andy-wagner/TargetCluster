package cluster;

import java.util.List;
import java.util.Set;

/**
 * @author EuiJin.Ham
 * @version 1.0.0
 * @description An interface for designing clustering utility
 * @param <T> Object Type to be designated as an arbitrary type that clustered data would be converted into
 */
public interface ICluster<T> {

    /**
     * A Method for explicitly making data
     */
    void make();

    /**
     * A Method to map the Clustered Raw Data into Arbitrary Type T
     * @param raw Clustered raw data
     * @return mapped data
     */
    T map(ClusteringRaw raw);

    /**
     * A method to take a single data unit by categories
     * @param category The Category Name
     * @param detail The Detail Category Name
     * @param keyword The Keyword
     * @return mapped clustered data
     */
    T take(String category, String detail, String keyword);

    /**
     * A method to take entire data as mapped state
     * @return all mapped clustered data
     */
    List<T> takeAll();

    /**
     * A method to take entire data as raw state
     * @return all raw clustered data
     */
    List<ClusteringRaw> asList();

}
