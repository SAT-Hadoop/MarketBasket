/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.marketbasket;

import edu.iit.sortingalgo.MergeSort;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.MapContext;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author supramo
 */
public class Map extends MapReduceBase implements Mapper {

    private static final Logger sLogger = Logger.getLogger(Map.class);

    private String mapTaskId;
    private String inputFile;

    @Override
    public void configure(JobConf job) {
        mapTaskId = job.get("mapred.task.id");
        inputFile = job.get("map.input.file");
    }

    @Override
    public void map(Object k1, Object v1, OutputCollector oc, Reporter rprtr) throws IOException {
        IntWritable one = new IntWritable(1);
        Text pair = new Text();
        String line = v1.toString();
        StringTokenizer tokenizer = new StringTokenizer(line);
        List listOfWords = new ArrayList();

        while (tokenizer.hasMoreTokens()) {
            //listOfWords.add(tokenizer.nextToken());
            String[] wordsInALine = tokenizer.nextToken().split(",");
            for (String wordsInALine1 : wordsInALine) {
                listOfWords.add(wordsInALine1);
            }
            MergeSort m = new MergeSort();
            listOfWords = m.sort(listOfWords);
            for (int i = 0; i < listOfWords.size() - 1; i++) {
                for (int j = i + 1; j < listOfWords.size(); j++) {
                    pair.set(listOfWords.get(i) + "_" + listOfWords.get(j));
                    sLogger.log(Level.INFO, "the words are " + mapTaskId + "  "+ listOfWords.get(i) + "_" + listOfWords.get(j));
                    oc.collect(pair, one);
                }
            }
        }

    }

}
