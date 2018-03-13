package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * 功能：基数排序
 * 
 * 原理：基数排序不需要进行记录关键字之间的比较。基数排序是一种借助多关键字排序思想对单逻辑关键字进行排序的方法。
 * 所谓的多关键字排序就是有多个优先级不同的关键字。比如说成绩的排序，如果两个人总分相同，则语文高的排在前面，
 * 语文成绩也相同则数学高的排在前面。。。如果对数字进行排序，那么个位、十位、百位就是不同优先级的关键字，如果要进行升序排序，
 * 那么个位、十位、百位优先级一次增加。基数排序是通过多次的收分配和收集来实现的，关键字优先级低的先进行分配和收集。
 * 
 * */
public class RadixSort {
	public static void main(String[] args){
		int[]  arr = {5, 3, 8, 6, 4, 0, 15, 7, 23, 9, 6, 6, 7, 8, 9};
		radixSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	public static void radixSort(int[] arr) {
        if(arr == null && arr.length == 0){
            return ;
        }
        int maxBit = getMaxBit(arr);

        for(int i=1; i<=maxBit; i++){
            List<List<Integer>> buf = distribute(arr, i); //分配
            collecte(arr, buf); //收集
        }
    }

    /**
     * 分配
     * @param arr 待分配数组
     * @param iBit 要分配第几位
     * @return
     */
    public static List<List<Integer>> distribute(int[] arr, int iBit) {
        List<List<Integer>> buf = new ArrayList<List<Integer>>();
        for(int j=0; j<10; j++) {
            buf.add(new LinkedList<Integer>());
        }
        for(int i=0; i<arr.length; i++) {
            buf.get(getNBit(arr[i], iBit)).add(arr[i]);
        }
        return buf;
    }

    /**
     * 收集
     * @param arr 把分配的数据收集到arr中
     * @param buf 
     */
    public static void collecte(int[] arr, List<List<Integer>> buf) {
        int k = 0;
        for(List<Integer> bucket : buf) {
            for(int ele : bucket) {
                arr[k++] = ele;
            }
        }
    }

    /**
     * 获取最大位数
     * @param x
     * @return
     */
    public static int getMaxBit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int ele : arr) {
            int len = (ele+"").length();
            if(len > max)
                max = len;
        }
        return max;
    }

    /**
     * 获取x的第n位，如果没有则为0.
     * @param x
     * @param n
     * @return
     */
    public static int getNBit(int x, int n) {
        String sx = x + "";
        if(sx.length() < n)
            return 0;
        else
            return sx.charAt(sx.length()-n) - '0';
    }
}
