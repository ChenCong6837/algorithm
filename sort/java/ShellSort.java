package sort;
/*
 * 功能：希尔排序(不稳定的排序算法)
 * 
 * 原理：希尔排序时插入排序的一种高效率的实现，也叫缩小增量排序。简单的插入排序中，如果待排序列时正序时，时间复杂度是O(n)，如果序列是
 * 基本有序的，使用直接插入排序效率就非常高。希尔排序就是利用了这个特点。基本思想是：先将整个待排记录序列分割成为若干子序列分别进行直接
 * 插入排序，待整个序列中的记录基本有序时在对全体记录进行一次直接插入排序。
 * 
 * 举例子： 对49，38，65，97，76，13，27，49，55，04进行排序，增量分别为5，3，1。
 * 则第一趟后的结果为：13，27，49，55，04，49，38，65，97，76
 * 第二趟后 的结果为：13，04，49，38，27，49，55，65，97，76
 * 最后一趟：04，13，27，38，49，49，55，65，76，97
 * 
 * 时间复杂度： 最好O(n),平均：O(n^1.3)
 * 
 * 空间复杂度：O(1)
 * 
 * */
public class ShellSort {
	public static void main(String[] args){
		int[]  arr = {5, 3, 8, 6, 4, -1, 0, 15, 7, 23, 9, 6, 6, 7, 8, 9};
		shellSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	public static void shellSort(int[] arr){
		if(arr == null || arr.length == 0){
			return;
		}
		int d = arr.length/2;  //d为增量
		while(d >= 1){
			shellInsert(arr, d);
			d /= 2;
		}
	}
	
	public static void shellInsert(int[] arr, int d){
		for(int i = d; i < arr.length; i++){
			int j = i - d;
			int temp = arr[i]; //记录要插入的数据
			while(j >= 0 && arr[j] > temp){  //从后向前，找到比其小的数的位置
				arr[j + d] = arr[j];  //向后挪动
				j -= d;
			}
			if(j != i - d){ //存在比其小的数
				arr[j + d] = temp; 
			}
		}
	}
}
