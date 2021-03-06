package cluster.model;

import cluster.ClusteringRaw;

import java.util.Map;

/**
 * @author EuiJin.Ham
 * @version 1.0.0
 * @description A Class for storing the simple result of clustering process
 */
public class SimpleClusterData {

    private String category;
    private String detailCategory;
    private Map<String, Integer> keywords;
    private int count = 0;

    /**
     * Default Constructor
     */
    public SimpleClusterData(){
    }

    /**
     * Constructor for mapping ClusteringRaw as SimpleClusterData
     * @param raw Clustered raw data
     */
    public SimpleClusterData(ClusteringRaw raw){
        this.category = raw.getCategory();
        this.detailCategory = raw.getDetailCategory();
        this.keywords = raw.getKeywords();
        this.count = raw.getCount();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDetailCategory() {
        return detailCategory;
    }

    public void setDetailCategory(String detailCategory) {
        this.detailCategory = detailCategory;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "SimpleClusterData{" +
                "category='" + category + '\'' +
                ", detailCategory='" + detailCategory + '\'' +
                ", keyword='" + keywords + '\'' +
                ", count=" + count +
                '}';
    }
}
