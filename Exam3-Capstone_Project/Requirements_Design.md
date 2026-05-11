Capstone Project - Phase 1: Requirements & Design

Project Track:
 - Option C: The Intelligent Cache (Hash Tables & Lists)
   - Real-World Context: Web browser caches, "Recent Chats" history, or Fraud Detection systems.
   - The Problem: Providing instant access to frequently used data while managing limited memory.
   - Key Challenge: How do you store millions of records to allow for $O(1)$ instant retrieval?
   - Required Structures: HashMap combined with a Doubly Linked List (LRU Cache pattern) or Dynamic Arrays.


Goal:
 - Design a cache that can store, retrieve, update, and delete the cache data with O(1) in time complexity.

Required Structures: 
 - HashMap and Double Linked List (LRU Cache pattern)

A cache stores recently used information so that it can be accessed later quickly.  The problem is that 
a cache has limit capacity.  

When the cache is full, the system must remove the least recently used item before adding a new item.

Data Structure Design:
  - HashMap is used to:
    - store key/value pairs
    - lookup by key
   
      
  - Double Linked List is used:
    - maintain the order of usage.
    - The most recently used item are moved to the front of the list
    - The least recenlty used item will be removed from the back of the list

HashMap will have O(1) time complexicy when accessing to each node using keys to store or lookup data

Double Linked List will have O(1) time complexity when insert, move to front,  or remove a node

```text
+---------------------------+

| IntelligentCache |

+---------------------------+

| - capacity: int |

| - map: HashMap<Integer, CacheNode> |

| - head: CacheNode |

| - tail: CacheNode |

+---------------------------+

| + get(key: int): int |

| + put(key: int, value: String): void |

| + remove(key: int): String |

| + size(): int |

| + isEmpty(): boolean |

| + displayCache(): void |

| - moveToFront(node: CacheNode): void |

| - removeNode(node: CacheNode): void |

| - addToFront(node: CacheNode): void |

| - removeLeastRecentlyUsed(): void |

+---------------------------+

              |
              v

+---------------------------+

| CacheNode |

+---------------------------+

| - key: int |

| - value: String |

| - prev: CacheNode |

| - next: CacheNode |

+---------------------------+
```










