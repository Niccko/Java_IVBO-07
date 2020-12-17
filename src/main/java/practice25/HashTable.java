package practice25;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class HashTable<K,V> implements HashMapInterface<K,V>{
    private final int capacity = 128;
    Entry<K,V>[] buckets;
    Entry<K,V> curPtr;
    int bucketIndex = 0;


    public HashTable() {
        buckets = new Entry[capacity];
    }

    public int keyHash(K key){
        return key.hashCode()>>2;
    }

    @Override
    public void add(K key, V value) {
        int bucket = keyHash(key)%capacity;
        Entry<K,V> ptr = buckets[bucket];
        if(ptr != null){
            while(true) {
                if(ptr.getKey().equals(key)){
                    ptr.setValue(value);
                    return;
                }
                if(!ptr.hasNext()) break;
                ptr = ptr.getNext();
            }
            ptr.setNext(new Entry<>(key,value));
        } else {
            buckets[bucket] = new Entry<>(key,value);
        }
        int i = 0;
        while(buckets[i]==null) i++;
        curPtr = buckets[i];
        bucketIndex=i;
    }

    @Override
    public V get(K key) {
        int bucket = keyHash(key)%capacity;
        Entry<K,V> ptr = buckets[bucket];
        if(ptr!=null){
            while(!key.equals(ptr.getKey())) {
                ptr = ptr.getNext();
                if(ptr==null) break;
            }
        }
        if(ptr!=null) return ptr.getValue();
        return null;
    }

    @Override
    public V remove(K key) {
        int bucket = keyHash(key)%capacity;
        Entry<K,V> ptr = buckets[bucket];
        if(ptr==null) return null;
        if (key.equals(ptr.getKey())) {
            buckets[bucket] = ptr.getNext();
            return ptr.getValue();
        }
        while(!key.equals(ptr.getNext().getKey())) {
            ptr = ptr.getNext();
            if(ptr.getNext() == null) break;
        }
        return ptr.getValue();
    }
    class HashIterator implements Iterator<Entry<K, V>> {
        private final HashTable<K,V> ht;

        HashIterator(HashTable<K,V> ht){
            this.ht = ht;
        }
        @Override
        public boolean hasNext() {
            if(curPtr!=null) {
                if (curPtr.getNext() != null) {
                    return true;
                } else if (bucketIndex < ht.capacity - 1) {

                    return buckets[bucketIndex] != null;
                }
            }
            int i = 0;
            while(i<capacity-1&&buckets[i]==null) i++;
            curPtr = buckets[i];
            bucketIndex=i;
            return false;
        }

        @Override
        public Entry<K, V> next() {
            if (curPtr.getNext() != null) {
                return curPtr = curPtr.getNext();
            } else
            {
                Entry k = buckets[bucketIndex];
                int i = bucketIndex+1;
                while(i<capacity-1&&buckets[i]==null) i++;
                curPtr = buckets[i];
                bucketIndex=i;
                return k;
            }
        }
    }
    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new HashIterator(this);
    }

}
