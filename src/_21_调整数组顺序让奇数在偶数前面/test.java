package _21_调整数组顺序让奇数在偶数前面;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {2,4,6};
		nums = s.exchange(nums);
		System.out.println(Arrays.toString(nums));
	}

}
