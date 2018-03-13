package sort;
/*
 * 功能：冒泡排序（稳定的排序算法）
 * 
 * 原理：通过与相邻的元素比较和交换来把小的数换到最前面。
 * 
 * 举例： 对5,3,8,6,4 进行冒泡排序。首先先从后往前冒泡，4和6比较，把4换到前面，序列变成5,3,8,4,6。同理4和8交换，变成5,3,4,8,6, 
 * 3和4无需交换。5和3交换，变成3,5,4,8,6。一遍冒泡排序结束，把最小的3排到最前面了。对剩下的序列依次冒泡，最终就可以得到一个有序的序列。
 * 
 * 时间复杂度： O(n的平方)
 *
 * */
public class BubbleSort {
	public static void main(String[] args){
		int[]  arr = {5, 3, 8, 6, 4, -1, 0, 15, 7, 23, 9, 6, 6, 7, 8, 9};
		bubbleSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	public static void bubbleSort(int[] arr){
		if(arr == null || arr.length == 0){
			return ;
		}
		int arrLength = arr.length;
		for(int i = 0; i < arrLength - 1; i++){
			for(int j = arrLength - 1; j > i; j-- ){
				if(arr[j] < arr[j - 1]){
					swap(arr, j - 1, j);
				}
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