package com.scottejames.mapreduce;


public class Pair<K, V> {
    private K key; 
    private V value; 

    public Pair()
    {
    	
    }
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public Pair(Pair<K, V> p) {
        this.key = p.key;
        this.value = p.value;
    }
    
    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
    

}
