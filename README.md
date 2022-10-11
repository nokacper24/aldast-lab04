# Lab 04: Trees
Contributors: 
- Kacper Lukasz Nowicki [kacperln@ntnu.no](mailto:kacperln@ntnu.no)
- Jakob Holkestad Molnes [jakobmo@ntnu.no](mailto:jakobmo@ntnu.no)
## Q1
### a)
![](img/q1a.jpg)
### b)
![](img/q1b.jpg)
### c)
if $n=3$, $n!=6$ insertion combinations, $5$ different trees
![](img/q1c.jpg)  
Probability for each tree is $1\over6$, though the same tree appears twice, thus probability for that particular one is ${2\over6}={1\over3}$  
If all possible trees had the same probability, it would be $1\over5$

## Q2
*in order to call ay of bellow methods, pass the **root node** of the tree as parameter*
### a)
```java
public void inOrderTraversal(Node node) {
    if (node == null) {
        return;
    }
    inOrderTraversal(node.left);
    System.out.println(node.item);
    inOrderTraversal(node.right);
}
```
### b)
```java
public void postOrderTraversal(Node node) {
    if (node == null) {
        return;
    }
    postOrderTraversal(node.right);
    System.out.println(node.item);
    postOrderTraversal(node.left);
}
```
### c)
```java
public void preOrderTraversal( Node node) {
    if (node == null) {
        return;
    }
    System.out.println(node.item);
    preOrderTraversal(node.left);
    preOrderTraversal(node.right);
}
```

### Q3