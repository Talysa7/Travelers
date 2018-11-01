package count;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	private IntWritable one=new IntWritable(1);
	private Text word=new Text();
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		StringTokenizer st=new StringTokenizer(value.toString());
		while(st.hasMoreTokens()) {
			word.set(st.nextToken());
			context.write(word, one);
		}
	}
}
