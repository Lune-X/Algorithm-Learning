# 					Algorithm Learning outcomes


## Day1: Bubble Sort——冒泡排序

双重循环控制数组遍历

**外层循环：**

外层循环的条件是：

```
for (int i = 0; i < array.length - 1; i++) {
```

对于长度为 8 的数组，`array.length - 1` 就是 `7`，所以 `i` 的取值范围是 `0` 到 `6`。外层循环控制着执行排序的轮数，最多需要 `array.length - 1` 次轮次排序。

**内层循环：**

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





## Day2:Inert Sort——插入排序

插入排序的工作原理是通过逐步将未排序部分的元素插入到已排序部分中，从而逐渐构建一个有序的数组。它假定数组的第一个元素是排序好的，然后从第二个元素开始，将每个元素依次插入到已经排序的数组部分中。插入时，依次比较当前元素和已排序部分的元素，并将比当前元素大的元素向右移动，腾出位置给当前元素。



### **时间复杂度：**

- **最坏情况**：O(n²)（例如，输入数组是逆序的）。
- **最好情况**：O(n)（例如，输入数组已经是有序的）。
- **平均情况**：O(n²)。

由于插入排序需要不断地将元素插入到已排序部分中，最坏的情况下每次插入需要移动多个元素，因此时间复杂度是 O(n²)。不过，如果数组接近有序，它的效率会比较高，接近 O(n)。



### **空间复杂度**： 

O(1)





## Day3:Selection Sort ——选择排序

每次从未排序部分中选出最小（或最大）的元素，放到已排序部分的末尾，依次进行，直到整个数组有序。



### 时间复杂度：

O(n²) 因为存在两层嵌套循环。



### 空间复杂度：

O(1) 

选择排序是 **原地排序算法**，即除了少量的临时变量外，它不需要额外的存储空间。





## Day4:Merge Sort——归并排序

归并排序是一种基于 **分治法** 的排序算法。它通过将数组递归地分成两半，分别进行排序，然后再将排序好的部分合并成一个有序的数组。



### 归并排序的基本步骤：

1. **分割（Divide）**：将数组从中间分成两半，递归地对子数组进行排序。
2. **合并（Conquer）**：将两个已经排好序的子数组合并成一个有序的数组。



### 归并排序的特点：

- **递归思想**：数组被不断地划分，直到每个子数组只包含一个元素（一个元素的数组是天然有序的）。
- **合并阶段**：通过一个辅助数组，将两个有序的子数组合并成一个有序的数组。



### 时间复杂度：

归并排序的时间复杂度是 O(n log n)。

- **分割阶段**：数组每次都被划分为两部分，划分的深度为 `log n`，因为每次递归将问题规模减半。
- **合并阶段**：每次合并时，需要遍历整个数组，这需要 O(n) 的时间。
- 因此，总的时间复杂度是 O(n log n)。



### 空间复杂度：

归并排序的空间复杂度是 O(n)，因为每次合并时都需要借助额外的数组来存储左右子数组。

- **递归调用栈**：递归的深度是 `log n`，因此栈空间为 O(log n)。
- **辅助数组**：合并时需要临时数组存储左右子数组，辅助数组的空间复杂度是 O(n)。

因此，总的空间复杂度是 O(n)。



### 归并排序的优缺点：

- **优点**：
  - 稳定排序：相同元素的相对顺序不会改变。
  - 时间复杂度始终为 O(n log n)，不受数组初始状态的影响。
  - 适合处理大规模数据。
- **缺点**：
  - 需要额外的空间，空间复杂度为 O(n)，在处理大数据时可能会消耗较多内存。





## Day5 Quick Sort——快速排序

快速排序使用分治法（Divide and conquer）策略来把一个序列（list）分为两个子序列（sub-lists）。

快速排序又是一种分而治之思想在排序算法上的典型应用。本质上来看，快速排序应该算是在冒泡排序基础上的递归分治法。



### 伪代码：

```
 function quicksort(q)
 {
     var list less, pivotList, greater
     if length(q) ≤ 1 
         return q
     else 
     {
         select a pivot value pivot from q
         for each x in q except the pivot element
         {
             if x < pivot then add x to less
             if x ≥ pivot then add x to greater
         }
         add pivot to pivotList
         return concatenate(quicksort(less), pivotList, quicksort(greater))
     }
 }
```



### 算法步骤：

1. 挑选基准值：从数列中挑出一个元素，称为“基准”（pivot），
2. 分割：重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（与基准值相等的数可以到任何一边）。在这个分割结束之后，对基准值的排序就已经完成，
3. 递归排序子序列：递归地将小于基准值元素的子序列和大于基准值元素的子序列排序。



### 时间复杂度：

- **平均时间复杂度**：O(n log n)。快速排序通常具有良好的性能，平均情况下，每次分割都会将数组分为两个相对均等的部分，因此时间复杂度为 O(n log n)。
- **最坏时间复杂度**：O(n²)。最坏的情况出现在每次分割都只减少一个元素，例如，如果数组已经有序或接近有序，且基准点每次都选择第一个或最后一个元素，这样会导致不均匀的划分，从而导致时间复杂度为 O(n²)。
- **最好时间复杂度**：O(n log n)。当每次分割都非常均匀时，快速排序的性能是最好的。



### 空间复杂度：

- **空间复杂度**：O(log n)。快速排序的空间复杂度主要来自于递归调用的栈空间，平均情况下为 O(log n)，最坏情况下为 O(n)，当递归深度最大时，每次只划分出一个元素。



### 快速排序的优缺点：

- **优点**：
  - 快速排序通常比其他排序算法（如归并排序、堆排序）运行得更快，特别是对于大数据集，因为它避免了额外的内存开销。
  - 在大多数情况下，它的平均时间复杂度为 O(n log n)，且常数项较低。
- **缺点**：
  - 在最坏情况下，时间复杂度为 O(n²)，例如当数组已经有序或接近有序时，如果没有使用随机化选择基准点，可能会导致较差的性能。
  - 不稳定排序：快速排序不是稳定的排序算法，因为在分区时可能会改变相等元素的相对顺序。



### 快速排序的改进：

为了避免最坏情况（时间复杂度 O(n²)），可以在选择基准点时进行优化，例如：

- **随机化基准点**：随机选择基准点可以有效避免最坏情况。
- **三数取中法**：选择第一个、最后一个和中间元素的中值作为基准点。





## Day6 Array And LinkedList

- 数组和链表是两种基本的数据结构，分别代表数据在计算机内存中的两种存储方式：连续空间存储和分散空间存储。两者的特点呈现出互补的特性。
- 数组支持随机访问、占用内存较少；但插入和删除元素效率低，且初始化后长度不可变。
- 链表通过更改引用（指针）实现高效的节点插入与删除，且可以灵活调整长度；但节点访问效率低、占用内存较多。常见的链表类型包括单向链表、环形链表、双向链表。
- 列表是一种支持增删查改的元素有序集合，通常基于动态数组实现。它保留了数组的优势，同时可以灵活调整长度。
- 列表的出现大幅提高了数组的实用性，但可能导致部分内存空间浪费。
- 程序运行时，数据主要存储在内存中。数组可提供更高的内存空间效率，而链表则在内存使用上更加灵活。
- 缓存通过缓存行、预取机制以及空间局部性和时间局部性等数据加载机制，为 CPU 提供快速数据访问，显著提升程序的执行效率。
- 由于数组具有更高的缓存命中率，因此它通常比链表更高效。在选择数据结构时，应根据具体需求和场景做出恰当选择。



## Day7 Stack And Queue

- 栈是一种遵循先入后出原则的数据结构，可通过数组或链表来实现。
- 在时间效率方面，栈的数组实现具有较高的平均效率，但在扩容过程中，单次入栈操作的时间复杂度会劣化至 O(n) 。相比之下，栈的链表实现具有更为稳定的效率表现。
- 在空间效率方面，栈的数组实现可能导致一定程度的空间浪费。但需要注意的是，链表节点所占用的内存空间比数组元素更大。
- 队列是一种遵循先入先出原则的数据结构，同样可以通过数组或链表来实现。在时间效率和空间效率的对比上，队列的结论与前述栈的结论相似。
- 双向队列是一种具有更高自由度的队列，它允许在两端进行元素的添加和删除操作。
