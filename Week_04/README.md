# Week Four Summrize

## Brain Map

https://gitee.com/xiaozefeng/images/raw/master/Week_Four.png

## DFS

Deepth First Search

### Code Template

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

### Code Template

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



### Homework

> 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

#### 第一种思路: 强上二分搜索

这个思路基于旋转的数组总有一半是有序的

1. 如果target在有序的一半中，使用二分搜索即可
2. 如果target不在有序的那一半中，就查询另一半，再讲另一半分为两半 (一半有序，一半无序)

```java
//  以mid为界限总有一半数组是有序的
public int search(int[] nums, int target) {
    int n = nums.length;
    if (n == 0) return -1;
    int l = 0;
    int r = n - 1;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] == target)
            return mid;

        if (nums[0] <= nums[mid]) { // 有序处理逻辑
            if (nums[0] <= target && target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        } else {
            if (nums[mid] < target && target <= nums[n - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }

    return -1;
}
```

#### 第二种思路 

1. 先找到数组旋转的位置
2. 基于这个旋转的位置，找到有序数组真正的mid，进行二分搜索

```java
public int search(int[] nums, int target) {
    // 1. find rotated index
    int l = 0, r = nums.length - 1;
  // 找到旋转的索引
    while (l <r) {
        int mid = l + (r - l) / 2;
        if (nums[mid]> nums[r]) l = mid + 1;
        else r = mid;
    }
    // 2. binary search based rotated index
    int rotatedIndex = l;
    l = 0;
    r = nums.length - 1;
    while (l <=r) {
        int mid = l+(r - l) / 2;
      // 基于旋转的索引找到有序数组的mid
        int realMid = (mid + rotatedIndex) % nums.length;
        if (nums[realMid] == target ) return realMid;
        else if (nums[realMid]< target) l = mid + 1;
        else r = mid - 1;
    }
    return -1;
}
```

