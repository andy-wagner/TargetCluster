# TargetCluster

#### A Clustering Utilities for collecting text-based statistic data with intuitive builder.

> cluster
- A Package for implementing analyzing and clustering logics.

> source
- A Package for designing various data sources

> storage
- A Package for storing the result data. e.g) Databases, files and caches

> target
- An explicit limitation of data for analysis and collecting



> Example for TargetBuilder

```java
public static void main(String... args) {

        Target target = Target.builder()
                .debug()
                .addCategories("Seoul", "Tokyo").addKeywords("Food")
                .addDetail("Seoul", "Tour")
                .addDetails("Tokyo", "Tour", "Ramen")
                .addKeywords("Keyword", "Keyword2", "Keyw3ord", "Keyword1")
                .addSynonym("Seoul", "Seoul-Si")
                .addSynonyms("Seoul", "Tokyo", "seoul-si") // Tokyo - Error(Existing in category)
                .build();

        // Tried to put synonym which is existing in domain category set[Tokyo]. Ignoring this operation since the operation can occur recursive error.

        // Target{
        // targetConfig=TargetConfig{
        // category={Seoul=[[NOT_CLASSIFIED], Tour], Tokyo=[Ramen, [NOT_CLASSIFIED], Tour]},
        // synonym={seoul-si=Seoul, Seoul-Si=Seoul},
        // keywords=[Keyword2, Keyword1, Keyword, Keyw3ord, Food],
        // caseSensitive=true,
        // debug=true}
        // }
        
    }
```

> Licenses

![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

- Aho CoraSick Algorithm For Efficient String Matching [0.4.0]
