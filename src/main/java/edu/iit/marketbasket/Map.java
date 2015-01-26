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
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


/**
 *
 * @author supramo
 */
public class Map extends MapReduceBase implements Mapper {   

    @Override
    public void map(Object k1, Object v1, OutputCollector oc, Reporter rprtr) throws IOException {
        String line = v1.toString();
        StringTokenizer tokenizer = new StringTokenizer(line);
        List listOfWords = new ArrayList();
        while (tokenizer.hasMoreTokens()){
            listOfWords.add(tokenizer.nextToken());
        }
        MergeSort m = new MergeSort();
        listOfWords = m.sort(listOfWords);
        
    }
    
}
