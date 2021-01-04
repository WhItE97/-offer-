package _11_旋转数组的最小数字;

public class Solution2 {
/**
 * 非递归实现
 */
	public int minArray(int[] numbers) {
		if(numbers[0]<numbers[numbers.length-1]) {
			//如果一开始就有序，直接返回首个元素
			return numbers[0];
		}
		int left = 0;
		int right = numbers.length-1;
		while(right-left>1) {
			int mid = (left+right)/2;
			if(numbers[left]==numbers[mid]&&numbers[left]==numbers[right]) {
				//如[1,0,1,1,1]和[1,1,1,0,1]——>不能通过numbers[mid]==numbers[left]来判定该mid元素属于第一个递增数组！
				return numbers[SequentialSearch(numbers)];
			}
			if(numbers[mid]>=numbers[left]) {
				//如果mid元素≥left元素，则mid在第一个递增数组，分界点在mid和right之间
				left = mid;
				continue;
			}
			else {
				//mid元素＜left元素，则mid元素在第二个递增数组，分界点在left和mid之间
				right = mid;
				continue;
			}
		}
		return numbers[right];
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
