package _40_��С��k����;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution3 {
	/**
	 * ���۹ٷ����˼·3����ʱ��O(Nlogk)7.38%  �ռ�O(1)89.74%��
	 * (n������arr�ĳ��ȡ����ڴ����ʵʱά��ǰ kСֵ�����Բ���ɾ������ O(logk)��ʱ�临�Ӷȣ������������� n����������룬����һ����Ҫ O(nlogk)��ʱ�临�Ӷȡ�)
	 * ʵ��size=k�Ĵ���ѣ�һ��ʼֱ�Ӳ��룬����size==k��ÿ����������ͶѶ��Ƚϣ�����������滻
	 * 
	 * java����ͨ�����ȶ���ʵ��һ������ѣ�Ĭ����С���ѣ�
	 */
	public int[] getLeastNumbers(int[] arr, int k) {
		//base
		if(k<=0) {
			return (new int[] {});
		}
		if(k>=arr.length) {
			return arr;
		}
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());//�������reverseOrder����С����
		//�ȰѴ���Ѳ���k��
		for(int i=0;i<k;i++) {
			q.offer(arr[i]);
		}
		//���������������Ԫ�ض�����ͶѶ����Ԫ�رȽϣ���С�Ĳ����滻
		int i = k;//��¼arr��Ԫ��
		while(i<arr.length) {
			//ÿ�ֽ�����Ԫ�غͶѶ��Ƚϣ���С�Ĳ����ȥ
			int top = q.poll();
			if(top>arr[i]) {
				q.offer(arr[i]);
			}
			else {
				q.offer(top);
			}
			i++;
		}
		int[] res = new int[k];
		for(int j=0;j<k;j++) {
			res[j] = q.poll();
		}
		return res;
	}
}
