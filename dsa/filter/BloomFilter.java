package dsa.filter;

import java.util.BitSet;
import java.util.function.Function;

public class BloomFilter<T> {
    private final BitSet bitSet;
    private final int bitSetSize;
    private final int numberOfHashFunctions;
    private final Function<T, Integer>[] hashFunctions;

    @SafeVarargs
    public BloomFilter(int bitSetSize, Function<T, Integer>... hashFunctions) {
        this.bitSetSize = bitSetSize;
        this.bitSet = new BitSet(bitSetSize);
        this.numberOfHashFunctions = hashFunctions.length;
        this.hashFunctions = hashFunctions;
    }

    public void add(T item) {
        for (Function<T, Integer> hashFunction : hashFunctions) {
            int hash = hashFunction.apply(item);
            bitSet.set(Math.abs(hash % bitSetSize), true);
        }
    }

    public boolean mightContain(T item) {
        for (Function<T, Integer> hashFunction : hashFunctions) {
            int hash = hashFunction.apply(item);
            if (!bitSet.get(Math.abs(hash % bitSetSize))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Define two simple hash functions
        Function<String, Integer> hash1 = s -> s.hashCode();
        Function<String, Integer> hash2 = s -> s.hashCode() * 31;

        // Create a Bloom filter with a bitSetSize of 1000 and 2 hash functions
        BloomFilter<String> bloomFilter = new BloomFilter<>(1000, hash1, hash2);

        // Add items to the Bloom filter
        bloomFilter.add("apple");
        bloomFilter.add("banana");
        bloomFilter.add("orange");

        // Check membership
        System.out.println(bloomFilter.mightContain("apple"));   // True (probably)
        System.out.println(bloomFilter.mightContain("banana"));  // True (probably)
        System.out.println(bloomFilter.mightContain("grape"));   // False (definitely not)
    }
}
