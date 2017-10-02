# TargetCluster

#### A Clustering Utilities for collecting text-based statistic data with a intuitive builder.

> cluster
- A Package for implementing analyzing and clustering logics.

> source
- A Package for designing various data sources

> storage
- A Package for storing the result data. e.g) Databases, files and caches

> target
- An explicit limitation of data for analysis and collecting



> Example Code Snippet

```java
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
            public SimpleClusterData map(ClusteringRaw raw, SimpleClusterData toMake) {
                return new SimpleClusterData(raw);
            }
        };

        /**
         * A Cluster Instance for Japan DataSource
         */
        Cluster<SimpleClusterData> clusterJapan = new SimpleCluster<SimpleClusterData>(target, dataSourceJapan) {
            @Override
            public SimpleClusterData map(ClusteringRaw raw, SimpleClusterData toMake) {
                return new SimpleClusterData(raw);
            }
        };

        // TODO implements SimpleClusterData, ClusteringRaw, SimpleCluster and aggregationFilter

    }
```

### Licenses

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

- Aho CoraSick Algorithm For Efficient String Matching [0.4.0]

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

- Jsoup Java HTML Parser [1.10.3]