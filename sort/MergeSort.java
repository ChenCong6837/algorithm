package sort;
/*
 * 功能：归并排序(稳定的排序算法)
 * 
 * 原理：递归分治的思想，先递归划分子问题，然后合并结果。把待排序列看成由两个有序的子序列，然后合并两个子序列，然后把子序列看成由两个有序
 * 序列。。。倒着来看，其实就是先两两合并，然后四四合并。。最终形成有序序列。
 * 
 * 例子：初始关键字49，38，65，97，76，13，27
 * 一趟归并：（38，49），（65，97），（13，76），27
 * 两趟归并：（38，49，65，97），（13，27，76）
 * 三趟归并：（13，27，38，49，65，76，97）
 * 
 *时间复杂度：平均O(nlogn),最好O(nlogn),最坏O(nlogn)
 *
 *空间复杂度O(n)
 * 
 * */
public class MergeSort {
	public static void main(String[] args){
		int[]  arr = {5, 3, 8, 6, 4, -1, 0, 15, 7, 23, 9, 6, 6, 7, 8, 9};
		mergeSort(arr, 0, arr.length - 1);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}

	/**
	 * 递归分治
	 * @param arr 待排数组
	 * @param left 左指针
	 * @param right 右指针
	 * */
	public static void mergeSort(int[] arr, int left, int right){
		if(left >= right){
			return ;
		}
		int mid = (left + right) / 2;
		mergeSort(arr, left, mid); //递归排序左边
		mergeSort(arr, mid + 1, right); //递归排序右边
		merge(arr, left, mid, right); //合并
	}
	
	/**
	 * 合并两个有序数组
	 * @param arr 待排序数组
	 * @param left 左指针
	 * @param mid 中间指针
	 * @param right 右指针
	 * */
	public static void merge(int[] arr, int left, int mid, int right){
		//[left,mid][mid+1,right]
		int[] temp = new int[right - left + 1]; //中间数组
		
		int i = left;
		int j = mid + 1;
		int k = 0;
		while(i <= mid && j <= right){
			if(arr[i] <= arr[j]){
				temp[k++] = arr[i++];
			}else{
				temp[k++] = arr[j++];
			}
		}
		while(i <= mid){
			temp[k++] = arr[i++];
		}
		while(j <= right){
			temp[k++] = arr[j++];
		}
		for(int p = 0; p < temp.length; p++){
			arr[left + p] = temp[p];
		}
	}
}
