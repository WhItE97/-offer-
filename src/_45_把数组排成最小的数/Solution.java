package _45_�������ų���С����;

/**
 * ��Ŀ��
 * ����һ���Ǹ��������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 */
public class Solution {
	/**
	 * self˼·��
	 * ȫ���У�ȡmin����>n!���������>bad
	 * 
	 * ��ָoffer TRICK������һ�� �µĴ�С��ϵ ��
	 * ab>ba => a>b (ͨ��1.�Է���2.�Գ���3.��������������֤��)
	 * 
	 * then self˼·��
	 * �����ϱȽϷ������������򣬵õ�һ�����������飬���������ַ�������
	 */
	public String minNumber(int[] nums) {
		//ð������
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<nums.length-i-1;j++) {
				if(compare(nums[j],nums[j+1])) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
		//��ɴ�С��������󣬰���������String���ؼ���
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<nums.length;i++) {
			sb.append(nums[i]);
		}
		return sb.toString();
    }
	
	public boolean compare(int a,int b) {
		String ab = new String(Integer.toString(a)+Integer.toString(b));//ƴ�ӿ���Խ�磡����ҪתString�Ƚ�
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
		return true;//ab=ba���򷵻�a>b����
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4,5,6,7,8,9,0};
		Solution s = new Solution();
		System.out.println(s.minNumber(nums));
	}
}
