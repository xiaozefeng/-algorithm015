# Week Two Summrize

## Map

### HashMap Summrize

[HashMap Summrize](https://github.com/xiaozefeng/-algorithm015/blob/master/Week_02/hashmap_summrize.md)





## Set

### HashSet 底层通过 HashMap实现, 利用HashMap的key 不能重复的特性来保证 HashSet元素的唯一性 (hashcode and equals)



## Tree

### Binary Search Tree (BST)

```java
class Node {
  E e;
  Node left;
  Node right;
}
```

左子树 < 当前节点  < 右子树， 所以在搜索元素的时候， 每次可以通过比较大小过滤一半的元素，搜索次数等于树的高度

这里可以拓展到 B树,  MySQL使用B树来存储数据 (而不是红黑树或者BST) 因为每个节点可以存储的元素比较多， 从而减少了树的高度，可以减少查询某一个元素的次数。





## Heap

### Binary Heap

#### 完全二叉树

对树中的结点按从上至下、从左到右的顺序进行编号



![heap](https://gitee.com/xiaozefeng/images/raw/master/heap.png)

#### 大顶堆

根节点是整个堆里最大的元素, 当前节点大于左右子树所有节点

#### 小顶堆

根节点是整个堆里最小的元素，当前节点小于左右子树所有节点



通过构建一颗  **完全二叉树**来保存堆的元素

使用**数组来存储二叉堆**的数据， 节点之间存在如下关系 **i是当前元素的索引**

1. 左孩子:  2*i +1
2. 右孩子: 2*i + 2
3. 父亲节点:  (i-1) /2



### SiftUp

往heap中添加元素时， 将元素添加到数组的尾部， O(1)的时间复杂度

但是插入的元素可能导致heap的性质被破坏， 所以需要将 插入的元素调整到指定位置， 这个从下往上的过程称之为**上浮**, 时间复杂度 O(logn)

### SiftDown

当要删除根节点 (最大值或最小值)时， 通过将 arr[0] 和 arr[arr.length-1]位置的元素互换， 这时heap的性质会被破坏， 需要将此时 根节点的元素进行 **下沉**操作, 以保证整个heap保持原有的性质 , 时间复杂度 O(logn)

### Heapify

接受一个数组， 将数组转换成heap， 整个过程称之为 heapify



## PriorityQueue

优先队列可以使用 Heap来实现, 最小堆或者最大堆都可以

PriorityQueue的优先级可以由我们自己定义， 通过传入一个 Comparator自定义比较的规则



## Graph

在树的基础上， 如果出现环就是图， 没有环就是树

树是特殊的图， 链表是特殊的树



## Brain Map

![heap](https://gitee.com/xiaozefeng/images/raw/master/Week_Two.png)

