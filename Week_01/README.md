# Week One Sumerize

## The brain map

![Week_One_Sumerize](https://gitee.com/xiaozefeng/images/raw/master/Week_One_Sumerize.png)



## DataStructure

### Array

内存连续

支持随机访问 , 访问O(1)

添加删除时间复杂度 O(n)

最好的情况是每次操作数组的尾部，均摊时间复杂度为 O(1)



### LinkedList

单链表：只有next, 双向链表有 previous 和 next

```java
class Node {
  private E e;
  private Node previous;
  private Node next;
}
```

通过 previous , next指针将元素挂接起来

不支持随机访问  访问时间复杂度O(n)

删除元素不需要群移 ,操作头尾最高效





### Stack

LIFO： 先进后出

应用： 系统栈，撤销操作, 括号匹配



### Queue

FIFO: 先进先出

应用: 排队, 广度优先遍历



### Deque

双端队列

头和尾都已操作， 既可以作为Stack ，也可以作为 Queue



### SkipList

空间换时间的做法，时间复杂度 O(n logn) ， 空间复杂度 O(n logn)

应用: Redis中的Zset底层数据结构



## Algorithm

算法的本质:  Branch , Loop , Recursion

找重复点



### 算法套路:

暴力:  枚举所有可能性

快慢指针

双指针

夹逼法 (怎么如此不雅呢)





## Some Feeling

用了超哥传授的 “五毒神掌”后学习到了很多解题的思想，虽然做题的觉得那些解题的都是 “神仙解题”， 但是觉得自己竟然学起来不觉得枯燥。只是恨自己基础不牢固， 像很多简单题都可以用暴力法解出来， 但是暴力解法我感觉自己看不懂， 反倒是哪些非暴力，巧妙的解法我感觉容易懂一些。“基础不牢，地动天摇” 古人诚不欺我

