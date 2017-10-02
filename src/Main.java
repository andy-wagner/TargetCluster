import cluster.Cluster;
import cluster.ClusteringRaw;
import cluster.SimpleCluster;
import cluster.model.SimpleClusterData;
import source.DataSource;
import source.BasicWebDataSource;
import source.SimpleDataSource;
import target.Target;

import java.io.IOException;

/**
 * @author EuiJin.Ham
 * @version 1.0.0
 * @description A Main entrance for igniting this application.
 */
public class Main {

    /**
     * main method
     * @param args running configuration
     */
    public static void main(String... args) {

        /**
         * Building a target instance
         */
        Target target = Target.builder()
                .debug()
                .addCategories("Korea", "Japan")
                .addDetails("Korea", "seoul", "pusan")
                .addDetails("Japan", "tokyo", "sapporo")
                .addKeywords("suicide", "mistake", "crash")
                .addSynonym("Seoul", "Seoul-Si")
                .addSynonyms("Pusan", "busan", "Busan-si") // Tokyo - Error(Existing in category)
                .build();

        /**
         * DataSources
         */
        DataSource dataSourceKorea = new SimpleDataSource("Some people make a mistake everyday in seoul, Korea.");
        DataSource dataSourceJapan = new SimpleDataSource("Some people suicide everyday in Japan.");

        /**
         * A Cluster Instance for Korea DataSource
         */
        Cluster<SimpleClusterData> clusterKorea = new SimpleCluster<SimpleClusterData>(target, dataSourceKorea) {
            @Override
            public SimpleClusterData map(ClusteringRaw raw) {
                return new SimpleClusterData(raw);
            }
        };

        /**
         * A Cluster Instance for Japan DataSource
         */
        Cluster<SimpleClusterData> clusterJapan = new SimpleCluster<SimpleClusterData>(target, dataSourceJapan) {
            @Override
            public SimpleClusterData map(ClusteringRaw raw) {
                return new SimpleClusterData(raw);
            }
        };



    }

}
