package cluster;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EuiJin.Ham
 * @version 1.0.5
 * @description A Class for storing entire Clustered data
 */
public class ClusteringRaw {

    private String category;
    private String detailCategory;
    private Map<String, Integer> keywords;
    private int count = 0;

    public ClusteringRaw(String category, String detailCategory, int count) {
        this();
        this.category = category;
        this.detailCategory = detailCategory;
        this.count = count;
    }

    public ClusteringRaw(String category, String detailCategory) {
        this();
        this.category = category;
        this.detailCategory = detailCategory;
    }

    public ClusteringRaw(){
        this.keywords = new HashMap<>();
    }

    /**
     * A Method for adding an elected keyword
     * @param keyword keyword to input
     */
    public void addKeyword(String keyword){
        if(this.keywords.containsKey(keyword)){
            int count = this.keywords.get(keyword);
            this.keywords.put(keyword, count + 1);
        }else{
            this.keywords.put(keyword, 1);
        }
    }

    public Map<String, Integer> getKeywords() {
        return keywords;
    }

    public void setKeywords(Map<String, Integer> keywords) {
        this.keywords = keywords;
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

    public void incCount(){
        this.count++;
    }

}
