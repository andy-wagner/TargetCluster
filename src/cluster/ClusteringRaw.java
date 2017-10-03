package cluster;

import java.util.Map;

/**
 * @author EuiJin.Ham
 * @version 1.0.0
 * @description A Class for storing entire Clustered data
 */
public class ClusteringRaw {

    private String category;
    private String detailCategory;
    private String keyword;
    private int count = 0;

    public ClusteringRaw(String category, String detailCategory, int count) {
        this.category = category;
        this.detailCategory = detailCategory;
        this.count = count;
    }

    public ClusteringRaw(String category, String detailCategory) {
        this.category = category;
        this.detailCategory = detailCategory;
    }

    public ClusteringRaw(){}

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

    public void incCount(){
        this.count++;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
