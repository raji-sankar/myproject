package com.leet.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    /**
     * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
     *
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
     *
     * Follow up:
     * Could you do both operations in O(1) time complexity?
     *
     * Example:
     *
     * LRUCache cache = new LRUCache( 2 /* capacity );
     *cache.put(1,1);
     *cache.put(2,2);
     *cache.get(1);       // returns 1
     *cache.put(3,3);    // evicts key 2
     *cache.get(2);       // returns -1 (not found)
     *cache.put(4,4);    // evicts key 1
     *cache.get(1);       // returns -1 (not found)
     *cache.get(3);       // returns 3
     *cache.get(4);       // returns 4
     */

    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

    }

    private void addNode(DLinkedNode node){
        node.prev = head;
        if(head != null) {
            node.next = head.next;

            if (head.next != null) {
                head.next.prev = node;
            }
            head.next = node;
        }


    }

    private void removeNode(DLinkedNode node){
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        if(prev != null) {
            prev.next = next;
        }
        if(next !=null){
            next.prev = prev;
        }

    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    int capacity;
    int size;
    private DLinkedNode head, tail;

    Map<Integer, DLinkedNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.getOrDefault(key, null);
        if(node == null){
            return -1;
        }else{
            moveToHead(node);
            return node.value;
        }

    }

    public void put(int key, int value) {

        DLinkedNode node = cache.get(key);

        if(node == null){

            node = new DLinkedNode();
            node.key = key;
            node.value = value;

            cache.put(key, node);
            addNode(node);
            ++size;
            if (size > capacity){
                cache.remove(popTail().key);
                --size;
            }
        } else{
            node.value = value;
            moveToHead(node);
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        int i = cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        i = cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        i = cache.get(1);       // returns -1 (not found)
        i = cache.get(3);       // returns 3
        i = cache.get(4);

    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
