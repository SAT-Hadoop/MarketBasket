/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.iit.sortingalgo.MergeSort;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author supramo
 */
public class MergeSortTest {
    
    public MergeSortTest() {
    }

    @Test
    public void sampleRun() {
        List a = new ArrayList();
        a.add("g");
        a.add("f");
        a.add("e");
        a.add("d");
        a.add("c");
        a.add("b");
        a.add("a");
        MergeSort m = new MergeSort();
        List b = m.sort(a);
        System.out.println(b.toString());
    }
}
