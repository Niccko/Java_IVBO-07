package practice25;

public interface HashMapInterface<K,V> extends Iterable<Entry<K,V>> {
    void add(K key, V value);
    V get(K key);
    V remove(K key);
}
