package cluster;

import cluster.constants.FlagState;
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
     * Debug Mode Flag
     */
    private boolean debug = false;

    /**
     * Default Constructor
     * @deprecated
     */
    @Deprecated
    public Cluster(){
        clusteringRawMap = new ConcurrentHashMap<>();
    }

    /**
     * Default Use Constructor
     * @param target target instance
     * @param dataSources datasource instances
     */
    public Cluster(Target target, List<DataSource> dataSources){
        this();
        this.target = target;
        this.dataSources = dataSources;
    }

    /**
     * Default Use Constructor
     * @param target target instance
     * @param dataSources datasource instances
     */
    public Cluster(Target target, DataSource... dataSources){
        this();
        this.target = target;
        this.dataSources = Arrays.asList(dataSources);
    }

    /**
     * Single DataSource Constructor
     * @param target target instance
     * @param dataSource datasource instance
     */
    public Cluster(Target target, DataSource dataSource){
        this();
        this.target = target;
        this.dataSources = new Vector<>();
        this.dataSources.add(dataSource);
    }

    protected static String generateCategoryKey(String category, String detail, String keyword){
        return String.format("%s-[CLUSTER_KEY]-$s-%s", category, detail, keyword);
    }

    public Iterator<String> iteratorForData(){
        return this.clusteringRawMap.keySet().iterator();
    }

    /**
     * A method to put the clustered result with category and detail category name
     * @param category Category name
     * @param detail Detail Category name
     * @return put Data
     */
    public ClusteringRaw putData(String category, String detail, String keyword){
        final String key = generateCategoryKey(category, detail, keyword);
        final ClusteringRaw clusterData;
        if(this.clusteringRawMap.containsKey(key)){
            clusterData = this.clusteringRawMap.get(key);
            int count = clusterData.getCount();
            clusterData.setCount(count + 1);
        }else{
            clusterData = new ClusteringRaw();
            clusterData.setCategory(category);
            clusterData.setDetailCategory(detail);
            clusterData.addKeyword(keyword);
            clusterData.setCount(1);
            this.clusteringRawMap.put(key, clusterData);
        }
        clusterData.addKeyword(keyword);
        return clusterData;
    }

    /**
     * A method to take a single data unit from clustered data (Functionally Duplicate with take(String, String))
     * @param category Category Name
     * @param detail Detail Category Name
     * @return Clustered data
     */
    public ClusteringRaw getData(String category, String detail, String keyword) throws NullPointerException{
        return this.clusteringRawMap.get(generateCategoryKey(category, detail, keyword));
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

    @Override
    public List<T> takeAll(){
        List<T> toRet = new Vector<>();
        Iterator<String> iterator = clusteringRawMap.keySet().iterator();
        while(iterator.hasNext()){
            toRet.add(map(clusteringRawMap.get(iterator.next())));
        }
        return toRet;
    }

    @Override
    public List<ClusteringRaw> asList(){
        List<ClusteringRaw> toRet = new Vector<>();
        Iterator<String> iterator = clusteringRawMap.keySet().iterator();
        while(iterator.hasNext()){
            toRet.add(clusteringRawMap.get(iterator.next()));
        }
        return toRet;
    }

    /**
     * A method to check if the keyword in parameter is existing in the keyword set
     * @param str The Keyword to check
     * @return A Result of the checking process
     */
    public boolean isStringExistingInKeywords(String str){
        return this.target.getKeywords().contains(str);
    }

    /**
     * A method to check if the keyword in parameter is existing in the category set
     * @param str The Keyword to check
     * @return A Result of the checking process
     */
    public boolean isStringExistingInCategories(String str){
        return this.target.getCategory().keySet().contains(str);
    }

    /**
     * A method to check if the detailed name in parameter is existing in the detail category set
     * @param category Category Name
     * @param detail Detailed Category
     * @return A Result of the checking process
     * @throws NullPointerException
     */
    public boolean isStringExistingAsDetail(String category, String detail) throws NullPointerException{
        final Set<String> ct = this.target.getCategory().get(category);
        return ct.contains(detail);
    }

    /**
     * A method to retrieve the category of string in parameter
     * @param detail Detailed category
     * @apiNote This method is using the linear method that it is highly inefficient
     * @return Category Names (This value might be none)
     */
    public Set<String> getCategoryOfDetail(String detail){
        final Map<String, Set<String>> map = this.target.getCategory();
        final Iterator<String> keys = map.keySet().iterator();
        final Set<String> categories = new HashSet<>();

        while(keys.hasNext()){
            final String key = keys.next();
            final Set<String> currentSet = map.get(key);
            final Iterator<String> cIterator = currentSet.iterator();
            while(cIterator.hasNext()){
                final String now = cIterator.next();
                if(this.target.isCaseSensitive()){
                    if(Target.TargetBuilder.flushSpaces(detail).equals(now)) categories.add(key);
                }else{
                    if(Target.TargetBuilder.flushSpaces(detail.toLowerCase()).equals(now.toLowerCase())) categories.add(key);
                }
            }
        }

        return categories;
    }

    /**
     * A method to find the type of keyword in parameter
     * @param str The keyword to find
     * @param hintCategory The category name (This parameter must be null if category could not be found yet)
     * @return FlagState
     */
    public FlagState decideWhatItIs(String str, String hintCategory){
        if(isDebug()){
            System.err.println(Thread.currentThread().getName() + " - " + String.format("[Cluster] decideWhatItIs called [%s, %s]", str, hintCategory));
        }
        if(isStringExistingInCategories(str)) {
            if(isDebug()){
                System.err.println(Thread.currentThread().getName() + " - " + "[Cluster] decideWhatItIs [FlagState.CATEGORY]");
            }
            return FlagState.CATEGORY;
        }
        if(isStringExistingInKeywords(str)) {
            if(isDebug()){
                System.err.println(Thread.currentThread().getName() + " - " + "[Cluster] decideWhatItIs [FlagState.KEYWORD]");
            }
            return FlagState.KEYWORD;
        }
        if(hintCategory != null){
            if(isStringExistingAsDetail(hintCategory, str)) {
                if(isDebug()){
                    System.err.println(Thread.currentThread().getName() + " - " + "[Cluster] decideWhatItIs [FlagState.DETAIL]");
                }
                return FlagState.DETAIL;
            }
        }
        if(isDebug()){
            System.err.println(Thread.currentThread().getName() + " - " + "[Cluster] decideWhatItIs [FlagState.NOTHING]");
        }
        return FlagState.NOTHING;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
