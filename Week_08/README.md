# Week 8

## Brain Map

![](https://gitee.com/xiaozefeng/images/raw/master/Week8.png)

## 位运算

为什么需要二进制:  在计算机底层就是用二进制表示数据的

为什么要有10进制: 人有十根手指，方便人类计数

#### 十进制转换成2进制

1. **余数短除法除以二**
2. **降二次幂及减法混合运算**



### 位运算符

| <<   | 左移 | 0011 => 0110                       |
| ---- | ---- | ---------------------------------- |
| >>   | 右移 | 0110 => 0011                       |
| \|   | 或   | 0011 \| 1011 => 1011               |
| &    | 与   | 0011 & 1011 => 0011                |
| ~    | 取反 | ~0011 => 1100                      |
| ^    | 异或 | 相同=0 不同=1  0011 ^ 1011 => 1000 |



### 常见的二进制操作

#### ^

x ^0 = x

x^1s  =x

x ^ (~x) = 1s

x ^x = 0



#### 判断奇偶

x &1 ==1 是奇数

x & 1 == 0 是偶数



#### 除2

x>>1 等于 除2

#### 清除最低位的1

x & (x-1)

#### 得到最低位的1

x & -x 



## Bloom Filter

用于判断一个元素是否在一个集合中

#### 特点

1. 集合元素很多 (用少量内存，存大量元素)
2. 判断结果不是很准确:  
   1. 如果判断的结果是不存在，那么这个元素一点不存在
   2. 如果判断的结果是存在， 那么这个元素不一定存在



#### 使用场景

- 在网络爬虫里，一个网址是否被访问过
- 在 FBI，一个嫌疑人的名字是否已经在嫌疑名单上
- 邮箱垃圾邮件过滤功能
- 缓存的前置过滤器 (如Redis)



## LRU Cache

least recently  cache: 最近最少使用

缓存排除算法

使用 Java 类库中的 `LinkedHashMap` 实现

```javascript
public class LRUCache  extends LinkedHashMap<Integer, Integer> {

    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }

}
```



## 排序算法

### 比较类排序

#### 基础排序算法

##### 选择排序 Selection Sort  O(n2)

**每次选择最小值**, 放到待排序数组的起始位置

##### 插入排序 Intersion Sort O(n2)

从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后往前扫描，找到对应位置**插入**

##### 冒泡排序 Bubble Sort O(n2)

嵌套循环，每次查看相邻的元素，如果逆序则交换位置



#### 高级排序算法

##### 快速排序 Quick Sort O(nlogn)

数组取标杆pivot , 将小元素放 pivot 左边，大元素放pivot右边, 然后依次对 pivot 左边和右边的子数组继续快排，以达到整个数组有序的目的

```java
public static void quickSort(int[] arr, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int begin, int end) {
        // pivot: 标杆位置 , counter: 小于pivot的元素个数
        int counter = begin;
        for (int i = begin; i < end; i++)
            if (arr[i] < arr[end]) swap(arr, i, counter++);

        swap(arr, end, counter);
        return counter;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```



##### 归并排序 Merge Sort O(nlogn)

1. 把长度为n的数组分为长度为n/2的两个子数组
2. 分别对两个子数组调用归并排序
3. 将两个排好序的子数组合并在一起

```java
public static void mergeSort(int[] arr, int left, int right) {
    if (right <= left) return;
    int mid = (right - left) >> 1;

    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
}

private static void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;

    while (i <= mid && j <= right)
        temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];

    while (i <= mid) temp[k++] = arr[i++];
    while (j <= right) temp[k++] = arr[j++];

    if (temp.length >= 0) System.arraycopy(temp, 0, arr, 0, temp.length);
}
```

##### 堆排序 Heap Sort O(nlogn)

1. 依次把元素加入到堆中
2. 依次将元素从堆顶中取出，放到数组对应位置

```java
public static void heapSort(int[] arr) {
    if (arr.length == 0) return;
    int len = arr.length;

    for (int i = len / 2 - 1; i >= 0; i--)
        heapify(arr, len, i);


    for (int i = len - 1; i >= 0; i--) {
        swap(arr, 0, i);
        heapify(arr, len, i);
    }
}

private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

private static void heapify(int[] arr, int len, int i) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int largest = i;
    if (left < len && arr[left] > arr[largest])
        largest = left;

    if (right < len && arr[right] > arr[largest])
        largest = right;

    if (largest != i) {
        swap(arr, i, largest);
        heapify(arr, len, largest);
    }
}


public static void heapSort2(int []arr) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int num : arr)
        pq.add(num);

    for (int i = 0; i < arr.length; i++)
        arr[i] = pq.remove();
}
```

