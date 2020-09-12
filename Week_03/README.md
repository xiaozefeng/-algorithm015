# Week Three Summrize

## Brain map

![heap](https://gitee.com/xiaozefeng/images/raw/master/Week_Three.png)

## Recursion

### Code template

```java
public void recursion(int level, int param){
  // terminator
  if (level >MAX_LEVEL) return;
  // process current level logic
  process(level, param);
  // drill down
  recursion(level+1, newParam);
  // reverse state if needed
}
```

### How to write `terminator`

**find the most basic question**

example :  traversal bst

```java
public void inorder(TreeNode root){
   //iternator
   if (root== null) return;  // the most basic question is the TreeNode == null 也就是说递归到底了
 
   inorder(root.left);   // drill down
   System.out.println(root.val); // process current level logic
   inorder(root.right);  // drill down
  
  // revert state
}
```



## Divide Conquer

find and solve sub problems

### Code template

```java
public int divide_conquer(problem, param1, param2 ...){
  // recursion terminator
  if(problem == null) 
    return  process_last_result();
  
  // prepare data
  data = prepare_data(problem);
  subproblems = split_problem(problem, data);
  
  // conquer subproblems
  subresult1 = divide_conquer(subproblems[0]);
  subresult2 = divide_conquer(subproblems[1]);
  subresult3 = divide_conquer(subproblems[2]);
  
  // process and generate the final result
  result = process_result(subresult1, subresult2, subresult3);
  return result; 
  // revert the current level states 
}
```



