# HashMap Summrize

![hashmap](https://gitee.com/xiaozefeng/images/raw/master/hashmap.png)

HashMap 实现了 Map 接口,  允许 `null key and null value,`

HashMap 遍历时，不能保证是添加元素时的顺序

HashMap的 `get` 和 `put` 操作最好的情况可以做到 O(1)的时间复杂度, 只要 `hash function ` 能把元素分散地放到 `buckets`

HashMap 有两个影响其性能的参数:  `load factor`, `capacity`, 当元素个数超过  `capacity * load factor`的值时就会进行 `rehash` 

`load factor` 的默认值是 `0.75` ， 这是对时间和空间的平衡,  当load factor 的值比较大时， 能装的元素更多了，但是可能产生更多的hash冲突，get和put 操作就可能变慢， 当 load facotr 的值较小时， 能装的元素比较少，会浪费较多的空间.

在使用HashMap时，当我们知道需要装多少个元素， 可以开一个足够大的空间, 避免发生 `rehash`

具体计算公式

```
传入的capacity = 实际存放的数据量 / 0.75
HashMap 会根据你传入的capacity 计算一个比 capacity大的数， 这个数一定是 2的n次幂
```



## 源码分析

### Constructor

```java
// 当size > threshold 就是扩容, 换句话说， threshold就是容量
public HashMap(int initialCapacity, float loadFactor) {
    this.loadFactor = loadFactor; // 负载因子
    this.threshold = tableSizeFor(initialCapacity);  // tableSizeFor 根据 initialCapacity 计算容量, 返回 大于initialCapacity的 2的n次幂的数
}
```



### Put

总体的逻辑是

判断table 为空或者长度为0就进行一次初始化

根据key找到在table中的位置，如果这个位置的值为空，插入一个新的node

如果这个位置不为空，判断hash值是否一致，判断key的是否相等 (equals)， 如果相等就用新的值替换旧的值

否则就看p是不是 TreeNode ， 如果是就添加到 TreeNode中, 如果不是TreeNode类型

就在当前butcket位置进行拉链法 (开一个链表), 插入到链表中, 如果链表过长 (长度超过8)会将链表转化成红黑树

```java
public V put(K key, V value) {
 		 // hash 函数，根据key 获取到一个数
    return putVal(hash(key), key, value, false, true);
}
```

```java
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;
    if ((p = tab[i = (n - 1) & hash]) == null)
        tab[i] = newNode(hash, key, value, null);
    else {
        Node<K,V> e; K k;
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        else if (p instanceof TreeNode)
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        else {
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    break;
                }
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    if (++size > threshold)
        resize();
    afterNodeInsertion(evict);
    return null;
```

if ((p = tab[i = (n - 1) & hash]) == null) 这里的 `(n-1) &hash ` 是计算key在 `table`中位置，这里很细节， 我们知道计算一个数在数组中的索引可以通过 `k % arr.length`来获取， 但是在源码中采用是 `(n-1) &hash `, 那是因为 位运算效率更高，但是使用这种运算方式来获取位置，必须n要是 2的n次幂，所以为什么在初始化的时候， `threshold`会被计算成2的n次幂



### Get

对key 进行 hash,  求得key在table中的下标

拿下标位置的元素跟传入的key做对比，如果相等， 直接返回该元素

如果不相等，判断是不是TreeNode, 如果是从红黑树中取找该元素

否则，遍历当前 bucket中的链表，找该元素， 找不到返回null

```java
public V get(Object key) {
    Node<K,V> e;
    return (e = getNode(hash(key), key)) == null ? null : e.value;
}
```

```java
final Node<K,V> getNode(int hash, Object key) {
    Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
    if ((tab = table) != null && (n = tab.length) > 0 &&
        (first = tab[(n - 1) & hash]) != null) {
        if (first.hash == hash && // always check first node
            ((k = first.key) == key || (key != null && key.equals(k))))
            return first;
        if ((e = first.next) != null) {
            if (first instanceof TreeNode)
                return ((TreeNode<K,V>)first).getTreeNode(hash, key);
            do {
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    return e;
            } while ((e = e.next) != null);
        }
    }
    return null;
}
```

