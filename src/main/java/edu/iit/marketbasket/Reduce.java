/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.marketbasket;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

/**
 *
 * @author supramo
 */
public class Reduce extends MapReduceBase implements Reducer {
    @Override
    public void reduce(Object k2, Iterator itrtr, OutputCollector oc, Reporter rprtr) throws IOException {
        int sum = 0;

        while (itrtr.hasNext()) {
            sum += Integer.parseInt(itrtr.next().toString());
        }
        oc.collect(k2, new IntWritable(sum));
    }
}
