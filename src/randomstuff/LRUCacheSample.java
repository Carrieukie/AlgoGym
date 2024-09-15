package randomstuff;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheSample {
//    public static void main(String[] args) {
//        // Create an LRU cache with a capacity of 2
//        LRUCache lruCache = new LRUCache(2);
//
//        // Add key-value pairs (1, 1) and (2, 2) to the cache
//        lruCache.put(1, 1);
//        lruCache.put(2, 2);
//
//        // Access key 1, should return 1
//        int result1 = lruCache.get(1);
//        assert result1 == 1 : "Error: Expected 1, got " + result1;
//        System.out.println("Value for key 1: " + result1); // Output: 1
//
//        // Add a new key-value pair (3, 3), this will evict the least recently used entry (key 2)
//        lruCache.put(3, 3);
//
//        // Access key 2, should return -1 (as it was evicted)
//        int result2 = lruCache.get(2);
//        assert result2 == -1 : "Error: Expected -1, got " + result2;
//        System.out.println("Value for key 2 (evicted): " + result2); // Output: -1
//
//        // Add a new key-value pair (4, 4), this will evict key 1 (as it was least recently used)
//        lruCache.put(4, 4);
//
//        // Check the current state of the cache
//        System.out.println("Current cache state: " + lruCache.linkedHashMap);
//        // Should print: {3=3, 4=4} (key 1 should be evicted)
//
//        // Assertions to verify the expected state of the cache
//        assert lruCache.linkedHashMap.containsKey(3) : "Error: Expected key 3 to be present.";
//        assert lruCache.linkedHashMap.containsKey(4) : "Error: Expected key 4 to be present.";
//    }
}

class LRUCache {
    LinkedHashMap<Integer, Integer> linkedHashMap;

    public LRUCache(int capacity) {
        // Initialize a LinkedHashMap with accessOrder set to true for LRU behavior
        linkedHashMap = new LinkedHashMap<>(
                capacity,
                0.75f,
                true
        ) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                // Remove the least recently used entry when the cache exceeds the capacity
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        // Return the value if the key is present, else return -1
        return linkedHashMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        // Add or update the key-value pair in the cache
        linkedHashMap.put(key, value);
    }
}

