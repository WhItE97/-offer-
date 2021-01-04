package _11_��ת�������С����;

public class Solution2 {
/**
 * �ǵݹ�ʵ��
 */
	public int minArray(int[] numbers) {
		if(numbers[0]<numbers[numbers.length-1]) {
			//���һ��ʼ������ֱ�ӷ����׸�Ԫ��
			return numbers[0];
		}
		int left = 0;
		int right = numbers.length-1;
		while(right-left>1) {
			int mid = (left+right)/2;
			if(numbers[left]==numbers[mid]&&numbers[left]==numbers[right]) {
				//��[1,0,1,1,1]��[1,1,1,0,1]����>����ͨ��numbers[mid]==numbers[left]���ж���midԪ�����ڵ�һ���������飡
				return numbers[SequentialSearch(numbers)];
			}
			if(numbers[mid]>=numbers[left]) {
				//���midԪ�ء�leftԪ�أ���mid�ڵ�һ���������飬�ֽ����mid��right֮��
				left = mid;
				continue;
			}
			else {
				//midԪ�أ�leftԪ�أ���midԪ���ڵڶ����������飬�ֽ����left��mid֮��
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
