package spring.storm;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;


public class ExclamationBolt extends BaseRichBolt {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OutputCollector _collector;

    public void prepare(Map conf, TopologyContext context, OutputCollector collector) {
        _collector = collector;
    }

    public void execute(Tuple tuple) {
    	
    String s	=tuple.getString(0) + "!!!";
    Integer s1	=tuple.getInteger(0);
    	
    	
        _collector.emit(tuple, new Values(s));
        _collector.emit(tuple, new Values(s1* 2));
        _collector.ack(tuple);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("word"));
    }    
}