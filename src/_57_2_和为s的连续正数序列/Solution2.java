package _57_2_和为s的连续正数序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
	/**
	 * 还是 双指针，更简洁的实现——>（在List—>array的转化上做提升!）【5ms 30%】
	 * 【CORE.IMP】
	 * 关于List<int[]> res = new ArrayList<>();
	 * 通过re[][] = res.toArray(new int[0][]);转换成二维数组！
	 * 其中int[0][]中的第一维0只是二维数组动态初始化【表明我要toArray的类型是二维数组！】所必须有的！第二维可填可不填！
	 * 详见https://blog.csdn.net/mucaoyx/article/details/86005283
	 */
	public int[][] findContinuousSequence(int target){
		List<int[]> res = new ArrayList<>();//【CORE.Collections的泛型是可以指定数组的！】
		int l = 1;
		int r = 2;
		while(l<r&&r<target) {
			if(serialSum(l,r)<target) {
				r++;
			}
			else if(serialSum(l,r)>target) {
				l++;
			}
			else {
				//1.把满足的l,r序列插入res
				int[] arr = new int[r-l+1];
				int tmp = l;
				for(int i=0;i<arr.length;i++) {
					arr[i] = tmp;
					tmp++;
				}
				res.add(arr);
				//2.l++
				l++;
			}
		}
		return res.toArray(new int[0][]);
	}
	
	public int serialSum(int start,int end) {
		return ((start+end)*(end-start+1))/2;
	}
	
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[][] res = s.findContinuousSequence(9);
		for(int i=0;i<res.length;i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}
}
