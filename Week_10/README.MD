# 期末总结

## Brain Map

![](https://gitee.com/xiaozefeng/images/raw/master/week10.png)

## 学习方法

### 如何精通一个领域
####  **Chunk it up 知识点切碎** 

把知识点先分解，再组装 (用自己的方式) ，再组织成 知识树  (脑图)

#### **Deliberate  Practicing 刻意练习**

**刷题四件套**: 

1. 审题&沟通
2. 寻找所有可能的解
3. 写代码 (多写)
4. Test Cases 测试用例

**五毒神掌:**  过遍数， 最大误区: 题只做一遍



#### **Feedback	反馈**:

多看高手代码，好代码

请高手看你的代码



## 数据结构

### Array

查询，修改  O(1) : 因为支持随机访问

增加,删除 O(n): 因为要挪动元素, 如果是在尾部添加，或者删除尾部的元素，时间复杂度为 O(1)



### LinkedList

查询 O(n), 查询头部(head) 和尾部(tail) 是O(1)的

修改，删除 O(n) ，操作head和tail时是O(1)的

**特点**: 操作头和尾是最高效的，操作中间部分效率较低

#### 如果提升中间部分的操作效率？

双向列表

跳表



### Stack & Queue

Stack :  LIFO (有效的括号)

Queue: FIFO (BFS)



### Set

不存在重复元素, 判重



### 哈希表

存储 Key-Value

数组+ 链表作为底层数据结构







## **算法思维**



## Recursion

```java
public void static recur(int level, int params) {
  // terminator
  if (level == MAX)
    return;
  // process current level logic
  process(params);
  // drill down
  recur(level +1, params);
  // reverse state
}
```



## divide & conquer

```python
def divide_conquer(problem, param1, param2, ...):
	# terminator
  if problem is None:
    print_result
    return
  # prepare data
  data = prepare_data(problem)
  subproblems = split_problem(problem,	data)
  
  # conquer subproblems
  subresult1 = self.divide_conquer(subproblems[0], p1, ...)
  subresult2 = self.divide_conquer(subproblems[0], p1, ...)
  subresult3 = self.divide_conquer(subproblems[0], p1, ...)
  
  # process and generate the final result
  result = process_result(subresult1, subresult2, subresult3)
  
  # revert the current level states
```

## DFS

Deepth First Search

```java
public List<List<Integer>> levelOrder(TreeNode root){
  List<List<Integer>> ans = new ArrayList<>();
  dfs(root, ans);
  return ans;
}

private void dfs(TreeNode node, List<List<Integer>> ans){
  if (node == null) return;
  if (level == ans.size()){
    ans.add(new ArrayList<>());
  }
  ans.get(level).add(node.val);
  dfs(node.left, ans);
  dfs(node.right, ans);
}
```



## BFS

Breadth First Search

```java
public List<List<Integer>> levelOrder(TreeNode root){
  if (root ==null) return;
  Deque<TreeNode> q = new LinkedList<>();
  q.offer(root);
  while(!q.isEmpty()){
    List<Integer> level = new ArrayList();
    int size = q.size();
    for(int i=0; i< size; i ++) {
      TreeNode node = q.poll();
      level.add(node.val);
      if(node.left!=null) q.offer(node.left);
      if(node.right!=null) q.offer(node.right);
    }
    ans.add(level);
  }
}
```



## Greedy Algorithm

> 解决子问题每一步都采用最优(最贪婪)解 , 从而希望能到全局 (最终)最优解

适用场景：求最优解

Greedy Algorithm 的难点是如何证明能用贪心算法达到最优

因为局部最优不代表全局最优

**和动归的区别是: 贪心法对子问题的求解不能回退，而动规可以保存以前的结果，可以选择性回退**





## Binary Search

### 二分使用场景

1. 有序 (单调递增或者递减)
2. 有上下边界
3. 可以根据索引访问元素

### Code Template

```java
public int binarySearch(int [] array, int target) {
  int left = 0;
  int right = array.length -1;
  int mid = left + (right -left) /2;
  while(left <= right){
    if(array[mid] < target) {
      right = mid -1;
    }else if( array[mid] > target){
      left = mid +1;
    }else {
      return mid;
    }
  }
}
```





### 动态规划

1. **Simplifying a complicated problem by breaking it down into simpler sub-problems**

**( in a recursion manner )**

2. Divide & Conquer + Optimal substructure 

   分治 + 最优子结构

3. DP: 动态递推



#### DP关键点

动态规划  和 递归 或者分治没有根本上区分， 关键看 **有无最优子结构**

它们之间的共同点: **找到重复子问题**

它们之间的不同点: dp有最优子结构的存在，中途可以淘汰次优解



#### 解DP问题的套路

1. 找到重复性
2. 定义dp状态 (一维或者多维)
3. 找状态转移方程 (DP方程)





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

