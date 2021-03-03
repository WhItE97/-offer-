package _45_把数组排成最小的数;

/**
 * 题目：
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class Solution {
	/**
	 * self思路：
	 * 全排列，取min——>n!个结果——>bad
	 * 
	 * 剑指offer TRICK：定义一种 新的大小关系 ！
	 * ab>ba => a>b (通过1.自反性2.对称性3.传递性三个方面证明)
	 * 
	 * then self思路：
	 * 用以上比较方法，进行排序，得到一个排序后的数组，按序连成字符串即可
	 */
	public String minNumber(int[] nums) {
		//冒泡排序
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<nums.length-i-1;j++) {
				if(compare(nums[j],nums[j+1])) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
		//完成从小到大排序后，把数组连成String返回即可
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<nums.length;i++) {
			sb.append(nums[i]);
		}
		return sb.toString();
    }
	
	public boolean compare(int a,int b) {
		String ab = new String(Integer.toString(a)+Integer.toString(b));//拼接可能越界！所以要转String比较
		String ba = new String(Integer.toString(b)+Integer.toString(a));
		for(int i=0;i<ab.length();i++) {
			if(ab.charAt(i)>ba.charAt(i)) {
				return true;
			}
			else if(ab.charAt(i)<ba.charAt(i)) {
				return false;
			}
			else {
				continue;
			}
		}
		return true;//ab=ba，则返回a>b成立
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4,5,6,7,8,9,0};
		Solution s = new Solution();
		System.out.println(s.minNumber(nums));
	}
}
