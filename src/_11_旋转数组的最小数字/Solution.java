package _11_��ת�������С����;
//�Լ��ĵݹ�д��..��ñ���������while��
public class Solution {
/**
 * ˼·��
 * ֱ�ӱ���Ч�ʵͣ�û������ת���������
 * ���������������ת����>���򣡡���>���ַ�
 * 
 * CORE:Ԫ�طֲ�����>��...����С...��
 * ����ÿ��ȡmidλ��Ԫ�أ��������leftָ���Ԫ�أ����midԪ���ڵ�һ�����������С���>�ֽ�㻹�ں��棬����left=mid
 * �����midԪ���ڵڶ������������С���>�ֽ����ǰ�棬right=mid
 */
	public int minArray(int[] numbers) {
		if(numbers[0]<numbers[numbers.length-1]) {//�����ת0��Ԫ�أ�������һ��ʼ��������ģ�ֱ�ӷ��ص�һ��Ԫ�أ�����СԪ�أ�
			return numbers[0];
		}
		int index = partition(numbers,0,numbers.length-1);
		return numbers[index];
	}
	
	/**
	 * ��ָ������ָǰ����������飬��ָ������ָ������������
	 * ������ָ�����=1��ʱ�򣬵ڶ���ָ����Ѿ�ָ���˷ֽ�Ԫ����С����һ���ˣ�
	 */
	public int partition(int[] numbers,int left,int right) {
		if(right-left<=1) {
			return right;
		}
		int mid = (left+right)/2;
		//MOST HDP�����left��Ԫ��=right��Ԫ��=mid��Ԫ�أ���[1,0,1,1,1]��[1,1,1,0,1]��
		//����>��mid=1�޷��ȿ����ڵ�һ�����飬Ҳ�����ڵڶ�������..��ʱ��ֻ��ת˳�����
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
