package sort;

import java.util.Arrays;

/*
 * 功能：计数排序
 * 
 * 原理：是线性时间复杂度的排序，只不过有前提条件，就是待排序的数要满足一定的范围的整数,而且技术排序需要比较多的辅助空间。其基本思想是，
 * 用待排序的数作为计数数组的下标，统计每个数字的个数。然后依次输出即可得到有序序列。
 * 
 * 时间复杂度：O(n)
 * 
 * */
public class CountSort {
	public static void main(String[] args){
		int[]  arr = {5, 3, 8, 6, 4, 0, 15, 7, 23, 9, 6, 6, 7, 8, 9};
		countSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	public static void countSort(int[] arr){
		if(arr == null || arr.length == 0){
			return ;
		}
		int max = max(arr);
		int[] count = new int[max + 1];
		Arrays.fill(count, 0);
		for(int i = 0; i < arr.length; i++){
			count[arr[i]]++;
		}
		int k = 0;
		for(int i = 0; i <= max; i++){
			for(int j = 0; j < count[i]; j++){
				arr[k++] = i;
			}
		}
		
	}
	public static  int max(int[] arr){
		int max = Integer.MIN_VALUE;
		for(int ele : arr){
			if(ele > max){
				max = ele;
			}
		}
		return max;
	}
}
