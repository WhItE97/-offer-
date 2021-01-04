package _11_旋转数组的最小数字;
//自己的递归写法..最好别这样！用while！
public class Solution {
/**
 * 思路：
 * 直接遍历效率低，没用上旋转数组的条件
 * 递增排序数组的旋转——>有序！——>二分法
 * 
 * CORE:元素分布——>中...大，最小...中
 * 所以每次取mid位置元素，如果大于left指针的元素，则该mid元素在第一个有序数组中——>分界点还在后面，所以left=mid
 * 否则该mid元素在第二个有序数组中——>分界点在前面，right=mid
 */
	public int minArray(int[] numbers) {
		if(numbers[0]<numbers[numbers.length-1]) {//如果旋转0个元素，即数组一开始就是有序的，直接返回第一个元素，即最小元素！
			return numbers[0];
		}
		int index = partition(numbers,0,numbers.length-1);
		return numbers[index];
	}
	
	/**
	 * 左指针用来指前半个递增数组，右指针用来指后半个递增数组
	 * 当两个指针距离=1的时候，第二个指针就已经指向了分界元素中小的那一个了！
	 */
	public int partition(int[] numbers,int left,int right) {
		if(right-left<=1) {
			return right;
		}
		int mid = (left+right)/2;
		//MOST HDP：如果left的元素=right的元素=mid的元素（如[1,0,1,1,1]和[1,1,1,0,1]）
		//——>其mid=1无法既可能在第一个数组，也可能在第二个数组..这时候只能转顺序查找
		if(numbers[mid]==numbers[left]&&numbers[left]==numbers[right]) {
			return SequentialSearch(numbers);
		}
		if(numbers[mid]>=numbers[left]) {
			left = mid;
			return partition(numbers,left,right);
		}
		else {
			right = mid;
			return partition(numbers,left,right);
		}
	}
	
	public int SequentialSearch(int[] numbers) {
		int min = numbers[0];
		int index = 0;
		for(int i=1;i<numbers.length;i++) {
			if(numbers[i]<min) {
				min = numbers[i];
				index = i;
			}
		}
		return index;
	}
}
