# TargetCluster [정형 데이터 카테고리 클러스터]

#### A Clustering Utilities for collecting text-based statistic data with a intuitive builder.
#### 직관적인 빌더를 이용하여 문자열 기반 통계자료를 수집하는 군집화 유틸리티

- Categorized Clustering Utility
- Synonym Recursive Filter
- Abstract Data Source
- Intuitive Category Builder
- Basic Web Data Source Utility

## Packages
> cluster
- A Package for implementing analyzing and clustering logics.
- 분석 및 군집화 로직을 구현한 패키지

> source
- A Package for designing various data sources
- 다양한 종류의 데이터 자원을 설계하기 위한 패키지

> storage
- A Package for storing the result data. e.g) Databases, files and caches
- 분석 결과 혹은 군집화 결과를 저장하기 위한 프로세스를 포함하는 패키지

> target
- An explicit limitation of data for analysis and collecting
- 분석 혹은 군집화 대상의 카테고리를 정의하기 위한 패키지

## Snippets

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

## Licenses

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

- Aho CoraSick Algorithm For Efficient String Matching [0.4.0]

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

- Jsoup Java HTML Parser [1.10.3]

## Members

- EuiJin.Ham (함의진) [https://www.github.com/yjham2002]