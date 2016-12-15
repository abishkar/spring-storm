package spring.storm;
import org.apache.storm.testing.TestWordSpout;
import org.apache.storm.topology.TopologyBuilder;

public class ConfStorm {
	public static TopologyBuilder main(String[] args) {
		TopologyBuilder builder = new TopologyBuilder();        
		builder.setSpout("words", new TestWordSpout(), 10);        
		builder.setBolt("exclaim1", new ExclamationBolt(), 3)
		        .shuffleGrouping("words");
		builder.setBolt("exclaim2", new ExclamationBolt(), 2)
		        .shuffleGrouping("exclaim1");
		return builder;

	}
	

}
