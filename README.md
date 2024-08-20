# 					Algorithm Learning outcomes

## Day1: Bubble Sort

双重循环控制数组遍历

### 外层循环：

外层循环的条件是：

```
for (int i = 0; i < array.length - 1; i++) {
```

对于长度为 8 的数组，`array.length - 1` 就是 `7`，所以 `i` 的取值范围是 `0` 到 `6`。外层循环控制着执行排序的轮数，最多需要 `array.length - 1` 次轮次排序。

### 内层循环：

内层循环的条件是：

```
for (int j = 0; j < array.length - 1 - i; j++) {
```

`j` 从 `0` 开始，一直到 `array.length - 1 - i`，这个条件控制了相邻元素的比较范围。每一轮都会把一个最大的元素“冒泡”到数组的末尾，因此，随着 `i` 的增加，内层循环的比较范围逐渐缩小，因为数组末尾已经排好序的部分不再需要比较。



### **时间复杂度：**

- **最坏情况**：O(n²)（完全逆序）
- **最好情况**：O(n)（已经有序）
- **平均情况**：O(n²)（随机顺序）



### **空间复杂度**：

O(1)



## Day2:Inert Sort

插入排序的工作原理是通过逐步将未排序部分的元素插入到已排序部分中，从而逐渐构建一个有序的数组。它假定数组的第一个元素是排序好的，然后从第二个元素开始，将每个元素依次插入到已经排序的数组部分中。插入时，依次比较当前元素和已排序部分的元素，并将比当前元素大的元素向右移动，腾出位置给当前元素。



### **时间复杂度：**

- **最坏情况**：O(n²)（例如，输入数组是逆序的）。
- **最好情况**：O(n)（例如，输入数组已经是有序的）。
- **平均情况**：O(n²)。

由于插入排序需要不断地将元素插入到已排序部分中，最坏的情况下每次插入需要移动多个元素，因此时间复杂度是 O(n²)。不过，如果数组接近有序，它的效率会比较高，接近 O(n)。



### **空间复杂度**：

O(1)