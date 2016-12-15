package spring.storm;


import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.utils.Utils;

public class Executor {
	public static void main(String[] args) {
		Config conf = new Config();
		conf.setDebug(true);
		conf.setNumWorkers(2);

		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("test", conf, ConfStorm.main(null).createTopology());
		Utils.sleep(10000);
		cluster.killTopology("test");
		cluster.shutdown();
	}

}
