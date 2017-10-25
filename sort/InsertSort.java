package sort;
/*
 * 功能：简单插入排序(稳定的排序算法)
 * 
 * 原理： 插入排序不是通过交换位置而是通过比较找到合适的位子插入元素来达到排序的目的。就像扑克牌，在整理牌的时候，就是拿到
 * 一张牌，找到一个合适的位置插入。这个原理和插入排序是一样的。
 * 
 * 例子：对5,3,8,6,4进行简单插入排序。首先第一个数不需要排序，然后第二个数3比5小，3要插到5前面，5往后移一位，变成3,5,8,6,4。
 * 然后3,5,8已经排好序，8不需要动，6插到8前面，8后移一位，4插到5前面，从5开始都向后移一位。注意在插入一个数的时候要保证这个数
 * 前面的数已经有序。
 * 
 * 时间复杂度： 平均O(n的平方)，最好O(n)--正序时，最差O(n的平方)--逆序时
 * 
 * 空间复杂度： O(1)
 * 
 * */
public class InsertSort {
	public static void main(String[] args){
		int[]  arr = {5, 3, 8, 6, 4, -1, 0, 15, 7, 23, 9, 6, 6, 7, 8, 9};
		insertSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	public static void insertSort(int[] arr){
		if(arr == null || arr.length == 0){
			return ;
		}
		for(int i = 1; i < arr.length; i++){
			int j = i;
			int target = arr[i]; //先保存要插入的元素
			while(j > 0 && target < arr[j - 1]){  //执行后移操作，比要插入的元素大都需要后移
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = target; //将插入的元素放到合适的位置
		}
	}
}
