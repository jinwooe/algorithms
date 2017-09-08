import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private LinkedList<Node> list = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node != null) {
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null) {
            node.value = value;
            list.remove(node);
            list.addFirst(node);
        }
        else {
            Node newNode = new Node(key, value);
            if(map.size() >= capacity) {
                map.remove(list.getLast().key);
                list.removeLast();
                list.addFirst(newNode);
            }
            else {
                list.addFirst(newNode);
            }

            map.put(key, newNode);
        }
    }

    class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
