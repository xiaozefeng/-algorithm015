# 第7周

## Brain Map

![](https://gitee.com/xiaozefeng/images/raw/master/Week7.png)

## Trie 字典树

多叉树

核心思想是用空间来换时间

### 场景

**大量** 字符串排查或者词频统计



### 代码模板

```java
public class UinonFind {
    private int count =0;
    private int [] parent;
    public UinonFind (int n) {
        count = n;
        parent = new int[n];
        for( int i = 0;i< n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while( p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ ) return;
        parent[rootP] = rootQ;
        count --;
    }
}
```



## UnionFind 并查集

### 场景

组团

配对

快速判断两个不同的个体是否在同一个集合中

### 代码模板

```java
public class Trie{
    private static class Node {
        public char val;
        public boolean endOfWord;
        public Node[] children = new Node[26];
    }
    public Node () {
    }
    public Node (char c) {
        Node node = new Node();
        node.val = c;
    }
    private final Node root;
    public Trie() {
        root = new Node();
        root.val=' ';
    }

    public void insert(String word) {
        if(word ==null || word.length() == 0) return;
        Node cur = root;
        for( char c : word.toCharArray()) {
            if (cur.children[c-'a'] == null)
                cur.children[c-'a'] = new Node();
            cur = cur.children[c-'a'];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        if(word ==null || word.length() == 0) return false;
        Node cur = root;
        for ( char c : word.toCharArray()) {
            if(cur.children[c-'a'] == null) return false;
            cur = cur.children[c-'a'];
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        if(word ==null || word.length() == 0) return false;
        Node cur = root;
        for (char c : prefix.toCharArray()){
            if(cur.children[c-'a'] == null) return false;
            cur = cur.children[c-'a'];
        }
        return true;
    }
}
```





## AVL树

**平衡二叉树**:  二分搜索树在最坏的情况下可能退化成链表，查询的时间复杂度从 O(logn) 退化成 O(n)

引入平衡二叉是主要是为了维持查询的效率在 O(logn)

### 平衡因子

**树的高度差** 每个树的节点都有一个平衡数，只能在 -1,0,1 之中，一旦绝对值超过1，就要进行 **旋转**，以保证树的平衡

### 旋转

一种保证树保平衡的手段

- 左旋
- 右旋
- 左右旋
- 右左旋



### Summary

适合读多写少:  因为是严格平衡的， 所以查询快， 但是要严格维护平衡，在插入时需要付出更多时间



## 红黑树

AVL 是要求完全平衡， 这样做的缺点是可能每次插入一个节点，都需要对树进行调整，有时间我是能够 **忍受** 高度差超过 2的

红黑树就是一种 **近似平衡二叉树**， 它能确保任何一个节点的 **左右子树** 的 **高度差小于两倍**

### 具体定义

- 树中存在两种节点， 红节点，黑节点
- 根节点  =  黑色
- 叶节点 & 空节点 = 黑色
- 相邻的两个节点不能都是红色
- 从任意节点到跟节点的路径上包含的黑色节点数量是一样的

#### Summary

不是严格平衡的二叉树， 所以查询相对较与AVL来说会慢一些， 但是插入时间会比AVL快

