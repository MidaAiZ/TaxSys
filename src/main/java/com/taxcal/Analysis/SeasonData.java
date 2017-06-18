package com.taxcal.Analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 二维坐标
 */

public class SeasonData implements Iterable<Float>{
    private List<Float> data;
    private double sum;

    public SeasonData(float[] input)
    {
        this.data = new ArrayList<Float>();
        this.sum = 0;
        int i = 0;
        while(i < input.length)
        {
            this.data.add(input[i]);
            i++;
        }
    }
    public double getTotal(){
        if(sum == 0) {
            for (float i : data) {
                sum += i;
            }
        }
        return sum;
    }
    public float getData(int index)
    {
        return this.data.get(index);
    }
    public int getCount(){return this.data.size(); }

    public Iterator<Float> iterator(){
        return new Iterator<Float>(){
            int cursor = 0;

            public boolean hasNext(){
                return cursor < getCount();
            }

            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             * @throws NoSuchElementException if the iteration has no more elements
             */
            public Float next() {
                return getData(cursor++);
            }

            /**
             * Removes from the underlying collection the last element returned
             * by this iterator (optional operation).  This method can be called
             * only once per call to {@link #next}.  The behavior of an iterator
             * is unspecified if the underlying collection is modified while the
             * iteration is in progress in any way other than by calling this
             * method.
             *
             * @throws UnsupportedOperationException if the {@code remove}
             *                                       operation is not supported by this iterator
             * @throws IllegalStateException         if the {@code next} method has not
             *                                       yet been called, or the {@code remove} method has already
             *                                       been called after the last call to the {@code next}
             *                                       method
             * {@link UnsupportedOperationException} and performs no other action.
             */
            public void remove() {

            }
        };
    }
}
