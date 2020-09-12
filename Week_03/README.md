# Week Three Summrize

## Brain map



## Recursion

### Code template

```java
public void recursion(){
  // terminator
  // process current level logic
  // drill down
  // revert state
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



