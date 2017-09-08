# algorithms

## LRUCache
Main idea is that whenever get() and put() operations are invoked on LRUCache, the linked list, which is used to maintain recent used nodes in the LRUCache, is reorganized. Specifically, the node which is used recently moves to first in the list.
Consquently, the least recently used node is located at last in the list. So if the cache has no room for another, the node at last in the list will be removed
