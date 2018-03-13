package sort;
/*
 * 功能：快速排序(不稳定的排序算法)
 * 
 * 原理：快速排序的思想也是来自冒泡排序。冒泡排序是通过相邻元素的比较和交换把最小的冒泡到最顶端，而快速排序是比较和交换小数和大数，这样
 * 一来不仅把小数冒泡到上面的同时也把大数沉到下面。
 * 
 * 例子：对5,3,8,6,4进行快排，思路是右指针找比基准数小的，左指针找比基准数大的，交换之。5,3,8,6,4以5作为比较的基准，最终会把比5小的
 * 移动到5的左边，比5大的移到5的右边。
 * 5,3,8,6,4首先设置i，j两个指针分别指向两端，j指针先扫描（为什么？），4比5小，停止。然后i扫描，8比5大，停止。
 * 交换i，j的位置。
 * 5,3,4,6,8然后j再扫描，这时j扫描4时两指针相遇，停止。然后交换4和基准数。
 * 4,3,5,6,8一次划分后达到了左边比5小，右边比5大的目的。之后对左右子序列递归排序，最终得到有序序列。
 * 
 * 为什么j先动？首先这也不是绝对的，这取决与基准数的位置，因为再最后两个指针相遇时，要交换基准数到相遇的位置。一般选取第一个数作为基准数，
 * 那么就是在左边，所以最后相遇的数要和基准数交换，那么相遇的数一定要比基准数小。所以j指针先移动才能找到比基准数小的数。
 * 
 * 时间复杂度： 平均O(nlogn)，最好O(nlogn)，最差O(n的平方)
 * 
 * 空间复杂度：O(logn)
 * 
 * */

public class QuickSort {
	public static void main(String[] args){
		int[]  arr = {5, 3, 8, 6, 4, -1, 0, 15, 7, 23, 9, 6, 6, 7, 8, 9};
		quickSort(arr, 0, arr.length - 1);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	//快排主函数
	public static void quickSort(int[] arr, int left, int right){
		if(left >= right){
			return ;
		}
		int pivotPos = partition(arr, left, right);
		quickSort(arr, left, pivotPos - 1);
		quickSort(arr, pivotPos + 1, right);
	}
	
	//一次划分
	public static int partition(int[] arr, int left, int right){
		int pivotKey = arr[left];
		while(left < right){
			while(left < right && arr[right] >= pivotKey ){ //向左直到找到比pivoKey小的数 
				right--;
			}
			arr[left] = arr[right];//把小的移到左边
			while(left < right && arr[left] <= pivotKey){ //向右直到找到比pivoKey大的数
				left++;
			}
			arr[right] = arr[left]; //把大的移到右边
		}
		arr[left] = pivotKey; //最后把pivot交换到中间
		return left;
	}
}