package _45_把数组排成最小的数;

import java.util.Arrays;

public class maopao {

	public static void main(String[] args) {
		int nums[] = new int[] {1,2,3,4,5,6,7,8,9,0};
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<nums.length-i-1;j++) {
				if(nums[j]>nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
		System.out.println("sorted:"+Arrays.toString(nums));
	}

}
