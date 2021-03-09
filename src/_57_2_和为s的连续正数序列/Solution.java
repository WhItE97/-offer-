package _57_2_和为s的连续正数序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class Solution {
	/**
	 * self思路：
	 * 【双指针】【思路ok但是因为不熟悉java的二维数组，所以下面从List<List>写入int[][]太臃肿——>时间9ms 11%..】
	 * 【同样双指针，更简洁的写法，见Solution2】
	 * l指向序列左侧，r指向序列右侧
	 * 1.(l+...+r)<target: r++
	 * 2.(l+...+r)>target: l++
	 * 3.(l+...+r)==target: (1)[l,...,r]add进res(2)l++继续match
	 */
	public int[][] findContinuousSequence(int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> route = new ArrayList<>();
		int l = 1;
		int r = 2;//因为起码包含2个数字
		while(l<r&&r<target) {
			if(serialSum(l,r)>target) {
				l++;
			}
			else if(serialSum(l,r)<target) {
				r++;
			}
			else {
				//1.把满足的序列add进res
				for(int i=l;i<=r;i++) {
					route.add(i);
				}
				res.add(new ArrayList<Integer>(route));
				route.clear();
				//2.l++
				l++;
			}
		}
		/**
		 * 【不熟悉java二维数组，这里写的太臃肿了！】
		 */
		int[][] ret = new int[res.size()][];//java二维数组动态初始化的其中一种，只声明第一维的维数，相当于每个arr[k]都是null，可以单独各异的初始化！
		for(int i=0;i<res.size();i++) {
			int[] arr = new int[res.get(i).size()];
			for(int j=0;j<res.get(i).size();j++) {
				arr[j] = res.get(i).get(j);
			}
			ret[i] = arr;
		}
		return ret;
    }
	
	public int serialSum(int start,int end) {
		return ((start+end)*(end-start+1))/2;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] res = s.findContinuousSequence(15);
		for(int i=0;i<res.length;i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}
}
