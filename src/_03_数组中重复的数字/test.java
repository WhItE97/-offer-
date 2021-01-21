package _03_数组中重复的数字;

public class test {
	public static void main(String[] args) {
		Solution s =  new Solution();
		int[] nums = new int[] {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		System.out.println(s.findRepeatNumber2(nums));
//		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
//		hm.put(11, 1);
//		hm.put(11, 2);
//		System.out.println("hm.size:"+hm.size());
//		System.out.println("key=11,value="+hm.getOrDefault(11, 0));
	}
}
