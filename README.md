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