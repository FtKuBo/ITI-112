public interface Map<K, V> {

    public boolean contains(K key);

    public void put(K key, V value);

    public Integer get(K key);

    public void replace(K key, V value);

    public V remove(K key);

}
