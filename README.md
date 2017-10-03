# TargetCluster [비정형 데이터 카테고리 클러스터]

#### A Clustering Utilities for collecting text-based statistic data with a intuitive builder.
#### 직관적인 빌더를 이용하여 문자열 기반 통계자료를 수집하는 군집화 유틸리티

## Overview

- Categorized Clustering Utility : This utility classifies the significant data with targeted categories. (Thread-Safe)
- Synonym Recursive Filter : This filter provides a function that eliminates the synonymously duplicate words.
- Abstract Data Source : This is provided for supporting various data sources.
- Intuitive Category Builder : This builder makes building category structure intuitive and easy. (Thread-Safe)
- Basic Web Data Source Utility : This utility provides the function to load data from web. (Note. Runs Synchronously.)

## Packages
> cluster
- A Package for implementing analyzing and clustering logics.
- 분석 및 군집화 로직을 구현한 패키지

> cluster.model
- A Package for including classes which is capsulating clustered data
- 군집화 데이터를 캡슐화하는 클래스 집합 패키지

> normalization
- A Package for normalizing text-based data with filter above.
- 위 언급된 필터를 이용하여 문자열을 정규화하기 위한 유틸리티 패키지

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

> Example Code Snippet [예시 및 코드]

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
                    .addSynonyms("Pusan", "busan", "Busan-si")
                    .build();
    
            /**
             * DataSources
             */
            DataSource dataSourceKorea1 = 
                new SimpleDataSource("Some people make a mistake everyday in seoul, Korea.");
            DataSource dataSourceKorea2 = 
                new SimpleDataSource("every single person makes a mistake everyday in Korea.");
            DataSource dataSourceJapan = 
                new SimpleDataSource("Some people suicide everyday in Japan.");
    
            /**
             * A Cluster Instance for Korea DataSource with multi-dataSource
             */
            Cluster<SimpleClusterData> clusterKorea = 
            new SimpleCluster<SimpleClusterData>(target, dataSourceKorea1, dataSourceKorea2) {
                @Override
                public SimpleClusterData map(ClusteringRaw raw) {
                    return new SimpleClusterData(raw);
                }
            };
    
            /**
             * A Cluster Instance for Japan DataSource
             */
            Cluster<SimpleClusterData> clusterJapan = 
            new SimpleCluster<SimpleClusterData>(target, dataSourceJapan) {
                @Override
                public SimpleClusterData map(ClusteringRaw raw) {
                    return new SimpleClusterData(raw);
                }
            };
    
            /**
             * Sets Debug Mode
             */
            clusterKorea.setDebug(true);
            clusterJapan.setDebug(true);
    
            /**
             * Makes cluster structure
             */
            clusterKorea.make();
            clusterJapan.make();
    
            /**
             * Extracts Results
             */
            System.out.println(Thread.currentThread().getName() + " - " + clusterKorea.takeAll());
            System.out.println(Thread.currentThread().getName() + " - " + clusterJapan.takeAll());
    
        }
```

## Licenses

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

- Aho CoraSick Algorithm For Efficient String Matching [0.4.0]

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

- Jsoup Java HTML Parser [1.10.3]

## Members

- EuiJin.Ham (함의진) [https://www.github.com/yjham2002]