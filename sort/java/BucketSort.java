package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * 功能：桶排序（稳定的排序算法）
 * 
 * 原理：桶排序算是计数排序的一种改进和推广。基本思想：假设有一组长度为N的待排关键字序列K[1....n]。首先将这个序列划分成M个的子区间(桶) 。
 * 然后基于某种映射函数 ，将待排序列的关键字k映射到第i个桶中(即桶数组B的下标 i) ，那么该关键字k就作为B[i]中的元素(每个桶B[i]都是一组
 * 大小为N/M的序列)。接着对每个桶B[i]中的所有元素进行比较排序(可以使用快排)。然后依次枚举输出B[0]....B[M]中的全部内容即是一个有序
 * 序列。bindex=f(key)   其中，bindex 为桶数组B的下标(即第bindex个桶), k为待排序列的关键字。桶排序之所以能够高效，其关键在于这个
 * 映射函数，它必须做到：如果关键字k1<k2，那么f(k1)<=f(k2)。也就是说B(i)中的最小数据都要大于B(i-1)中最大数据。很显然，映射函数的确
 * 定与数据本身的特点有很大的关系。
 * 
 * 例子：假如待排序列K= {49、 38 、 35、 97 、 76、 73 、 27、 49 }。这些数据全部在1—100之间。因此我们定制10个桶，
 * 然后确定映射函数f(k)=k/10。则第一个关键字49将定位到第4个桶中(49/10=4)。依次将所有关键字全部堆入桶中，
 * 并在每个非空的桶中进行快速排序后得到如图所示。只要顺序输出每个B[i]中的数据就可以得到有序序列了。
 * 
 * 时间空间复杂度：桶排序的平均时间复杂度为线性的O(N+C)，其中C=N*(logN-logM)。如果相对于同样的N，桶数量M越大，其效率越高，
 * 最好的时间复杂度达到O(N)。 当然桶排序的空间复杂度 为O(N+M)，如果输入数据非常庞大，而桶的数量也非常多，则空间代价无疑是昂贵的。
 * */
public class BucketSort {
	public static void main(String[] args){
		int[]  arr = {5, 3, 8, 6, 4, 0, 15, 7, 23, 9, 6, 6, 7, 8, 9};
		bucketSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	
	  public static void bucketSort(int[] arr) {
	        if(arr == null && arr.length == 0)
	            return ;
	        int bucketNums = 10; //这里默认为10，规定待排数[0,100)
	        List<List<Integer>> buckets = new ArrayList<List<Integer>>(); //桶的索引
	        for(int i=0; i<10; i++) {
	            buckets.add(new LinkedList<Integer>()); //用链表比较合适
	        }
	        
	        //划分桶
	        for(int i=0; i<arr.length; i++) {
	            buckets.get(f(arr[i])).add(arr[i]);
	        }
	        
	        //对每个桶进行排序
	        for(int i=0; i<buckets.size(); i++) {
	            if(!buckets.get(i).isEmpty()) {
	                Collections.sort(buckets.get(i)); //对每个桶进行快排
	            }
	        }
	        
	        //还原排好序的数组
	        int k = 0;
	        for(List<Integer> bucket : buckets) {
	            for(int ele : bucket) {
	                arr[k++] = ele;
	            }
	        }
	    }

	    /**
	     * 映射函数
	     * @param x
	     * @return
	     */
	    public static int f(int x) {
	        return x / 10;
	    }
}
