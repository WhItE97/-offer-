package _57_2_��Ϊs��������������;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
	/**
	 * ���� ˫ָ�룬������ʵ�֡���>����List��>array��ת����������!����5ms 30%��
	 * ��CORE.IMP��
	 * ����List<int[]> res = new ArrayList<>();
	 * ͨ��re[][] = res.toArray(new int[0][]);ת���ɶ�ά���飡
	 * ����int[0][]�еĵ�һά0ֻ�Ƕ�ά���鶯̬��ʼ����������ҪtoArray�������Ƕ�ά���飡���������еģ��ڶ�ά����ɲ��
	 * ���https://blog.csdn.net/mucaoyx/article/details/86005283
	 */
	public int[][] findContinuousSequence(int target){
		List<int[]> res = new ArrayList<>();//��CORE.Collections�ķ����ǿ���ָ������ģ���
		int l = 1;
		int r = 2;
		while(l<r&&r<target) {
			if(serialSum(l,r)<target) {
				r++;
			}
			else if(serialSum(l,r)>target) {
				l++;
			}
			else {
				//1.�������l,r���в���res
				int[] arr = new int[r-l+1];
				int tmp = l;
				for(int i=0;i<arr.length;i++) {
					arr[i] = tmp;
					tmp++;
				}
				res.add(arr);
				//2.l++
				l++;
			}
		}
		return res.toArray(new int[0][]);
	}
	
	public int serialSum(int start,int end) {
		return ((start+end)*(end-start+1))/2;
	}
	
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[][] res = s.findContinuousSequence(9);
		for(int i=0;i<res.length;i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}
}
