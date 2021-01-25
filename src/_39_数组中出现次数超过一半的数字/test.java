package _39_数组中出现次数超过一半的数字;


public class test {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		int[] arr = new int[] {6,5,5};
//		s.quicksort(arr, 0, arr.length-1);
//		System.out.println(Arrays.toString(arr));
		System.out.println(s.majorityElement(arr));
	}

}
