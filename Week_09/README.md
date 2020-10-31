# Week 9

## Brain Map

![](https://gitee.com/xiaozefeng/images/raw/master/Week9.png)

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





## 解决递归问题

1. 不要人肉递归，人肉递归低效，人容易累
2. 找最近，最简重复性，并将其转换成可重复解决的子问题
3. 数学归纳





### 动态规划

1. **Simplifying a complicated problem by breaking it down into simpler sub-problems**

**( in a recursion manner )**

2. Divide & Conquer + Optimal substructure 

   分治 + 最优子结构

3. DP: 动态递推



### DP关键点

动态规划  和 递归 或者分治没有根本上区分， 关键看 **有无最优子结构**

它们之间的共同点: **找到重复子问题**

它们之间的不同点: dp有最优子结构的存在，中途可以淘汰次优解



### 解DP问题的套路

1. 找到重复性
2. 定义dp状态 (一维或者多维)
3. 找状态转移方程 (DP方程)

