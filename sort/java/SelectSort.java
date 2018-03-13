package sort;
/*
 * 功能：简单选择排序(不稳定的排序算法)
 * 
 * 原理：选择排序的思想和冒泡排序有点类似，都是在一次排序后把最小的元素放在最前面。但是过程不同，冒泡排序是通过相邻的比较和交换。而
 * 选择排序是通过对整体的选择。
 * 
 * 例子：对5,3,8,6,4这个无序序列进行简单选择排序，首先要选5以外的最小数来和5交换，也就是选择3和5交换，一次排序后就变成3,5,8,6,4，对剩下的
 * 序列依次进行选择和交换，最终得到一个有序序列。其实选择排序可以看成是冒泡排序的优化，因为其目的相同，只是选择排序只有在确定了最小数的前提下
 * 才进行交换，大大减少了交换的次数。
 * 
 * 时间复杂度： 平均O(n的平方)，最好O(n)，最差O(n的平方)
 * 
 * 空间复杂度：O(1)
 * */
public class SelectSort {
	public static void main(String[] args){
		int[]  arr = {5, 3, 8, 6, 4, -1, 0, 15, 7, 23, 9, 6, 6, 7, 8, 9};
		selectSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	public static void selectSort(int[] arr){
		if(arr == null || arr.length == 0){
			return ;
		}
		for(int i = 0; i < arr.length - 1; i++){   // 只需比较n-1次
			int flag = i;   //记录最小值的下标
			for(int j = i+1; j < arr.length; j++){ //j要小于n，因为最后一个n-1需要比较，要不然遗漏一个元素
				if(arr[j] < arr[flag]){
					flag = j;
				}
			}
			if(flag != i){ //如果两个不相等，说明找到更小的值，则交换元素
				swap(arr, flag, i);
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] =temp;
	}
}
