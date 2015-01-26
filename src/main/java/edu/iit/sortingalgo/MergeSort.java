/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sortingalgo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author supramo
 */
public class MergeSort {

    List input,helper;

    public List sort(List input) {
        this.input = input;
        List output = new ArrayList();
        output = recursion(0, input.size() - 1);
        return output;
    }

    private List recursion(int low, int high) {

        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            recursion(low, middle);
            // Sort the right side of the array
            recursion(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }

        return this.input;
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        
        this.helper = new ArrayList();
        this.helper.addAll(this.input);

        int i = low;
        int j = middle + 1;
        int k = low;
    // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (((String)helper.get(i)).compareTo((String)helper.get(j)) < 1) {
                this.input.set(k, this.helper.get(i));
                i++;
            } else {
                this.input.set(k, this.helper.get(j));
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            this.input.set(k, this.helper.get(i));
            k++;
            i++;
        }

    }

}
