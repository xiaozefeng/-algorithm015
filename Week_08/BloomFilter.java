package org.mickey.homework.week8;

import java.util.BitSet;
import java.util.Iterator;
import java.util.Random;

public class BloomFilter {

    private BitSet hashes;
    private RandomInRange prng;
    private int k;
    private static final double LN2 = 0.6931471805599453;

    public BloomFilter(int n , int m) {
        k = (int) Math.round(LN2 * m / n);
        if (k <=0)k =1;
        this.hashes = new BitSet(m);
        this.prng = new RandomInRange(m, k);
    }

    public BloomFilter(int n) {
        this(n, 1024 * 1024 * 8);
    }

    public void add(Object o) {
        prng.init(o);
        for(RandomInRange r :prng) hashes.set(r.value);
    }

    public boolean contains(Object o) {
        prng.init(o);
        for (RandomInRange r : prng) {
            if(!hashes.get(r.value)) return false;
        }
        return true;
    }
    public void clear() {
        hashes.clear();
    }

    @Override
    public int hashCode() {
        return hashes.hashCode() ^ k;
    }

    public boolean equals(BloomFilter other) {
        return this.hashes.equals(other.hashes) && this.k == other.k;
    }

    public void merge(BloomFilter other) {
        if (other.k != this.k || other.hashes.size() != this.hashes.size()) {
            throw new IllegalArgumentException("Incompatible bloom filters");
        }
        this.hashes.or(other.hashes);
    }

    private static final class  RandomInRange implements Iterable<RandomInRange>, Iterator<RandomInRange> {
        private Random prng;
        private int max;
        private int count;
        private int i = 0;
        private int value;

        RandomInRange( int maximum, int k){
            max =maximum;
            count = k;
            prng = new Random();
        }

        public void init(Object o) {
            prng.setSeed(o.hashCode());
        }


        @Override
        public Iterator<RandomInRange> iterator() {
            i = 0;
            return this;
        }

        @Override
        public boolean hasNext() {
            return i <count;
        }

        @Override
        public RandomInRange next() {
            i++;
            value = prng.nextInt() % max;
            if (value<0) value = -value;
            return this;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
