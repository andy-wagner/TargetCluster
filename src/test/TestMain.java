package test;

import cluster.Cluster;
import cluster.ClusteringRaw;
import cluster.SimpleCluster;
import cluster.model.SimpleClusterData;
import source.BasicWebDataSource;
import target.Target;

import java.util.List;

public class TestMain {

    public static void main(String... args) throws Exception{

        BasicWebDataSource basicWebDataSource1 = new BasicWebDataSource("http://www.joongdo.co.kr/main/view.php?key=20171005010000724", "div.left_text_box");
        BasicWebDataSource basicWebDataSource2 = new BasicWebDataSource("http://www.joongdo.co.kr/main/view.php?key=20171005010000723", "div.left_text_box");
        basicWebDataSource1.collect();
        basicWebDataSource2.collect();

        Target.TargetBuilder targetBuilder = ConstKoreaLocation.getBuilderForLocationTarget();

        targetBuilder.addKeywords("절도", "징역", "절취", "성매매", "폭행", "음주");

        Target target = targetBuilder.build();

        Cluster<SimpleClusterData> cluster = new SimpleCluster<SimpleClusterData>(target, basicWebDataSource1, basicWebDataSource2) {
            @Override
            public SimpleClusterData map(ClusteringRaw raw) {
                return new SimpleClusterData(raw);
            }
        };

        cluster.make();
        List<SimpleClusterData> result = cluster.takeAll();

        for(SimpleClusterData data : result){
            System.out.println(data);
        }

    }

}
