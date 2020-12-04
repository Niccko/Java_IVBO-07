package practice25;

public class Entry<K,V> {
    private K key;
    private V value;
    Entry<K,V> next=null;

    public boolean hasNext(){
        return next != null;
    }

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Entry<K, V> getNext() {
        return next;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
