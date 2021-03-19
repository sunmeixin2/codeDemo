package code.Other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunmeixin
 * @description LRU缓存机制
 * @date 2021-02-27
 */
public class LRUCache2 {
    class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
        DLinkNode(){}
        DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkNode> cache;
    private int capacity,size;
    private DLinkNode head;
    private DLinkNode tail;

    public LRUCache2(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
        // 伪头部和伪尾部节点
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkNode newNode = new DLinkNode(key,value);
            // 添加进哈希表
            cache.put(key,newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            size++;
            if (size > capacity) {
                // Map 和 链表 移除尾部节点
                DLinkNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode (DLinkNode node ) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkNode removeTail(){
        DLinkNode node = tail.prev;
        removeNode(node);
        return node;
    }

    public static void main(String[] args) {
        LRUCache2 l = new LRUCache2(2);
        l.put(1,1);
        l.put(2,2);
        l.get(1);
        l.put(3,3);
        l.get(2);
        l.put(4,4);
        l.get(1);
        l.get(3);
        l.get(4);
    }
}
