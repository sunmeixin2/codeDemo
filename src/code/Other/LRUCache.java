package code.Other;

import java.util.*;

/**
 * @author sunmeixin
 * @description LRU缓存机制
 * @date 2021-02-27
 */
public class LRUCache extends LinkedHashMap<Integer,Integer> {


    private int capacity;
    public LRUCache(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}




