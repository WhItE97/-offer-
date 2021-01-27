package _41_�������е���λ��;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder2 {
	/**
	 * ��ָoffer˼·��������ʱ��O(logN) ����ʱ��O(1) ʱ��ϡ�������������Ϊ1/10��
	 * ����һ���󶥶Ѻ�һ��С���ѣ������ѱ���size�����1�����ڲ���׶α�֤[С���ѵ���][ȫ������][�󶥶�]
	 * �󶥶ѵĶ���С����һ������ֵ����С���ѵĶ��������һ�����Сֵ���͹�������λ����
	 */
	/** initialize your data structure here. */
	PriorityQueue<Integer> sheap;//small heap��small heap������Ԫ�ش���big heap
	PriorityQueue<Integer> bheap;//big heap
    public MedianFinder2() {
    	sheap = new PriorityQueue<>();//С����
    	bheap = new PriorityQueue<>(Collections.reverseOrder());//�󶥶�->peekҲ��peek�Ĵ󶥣�
    }
    
    public void addNum(int num) {
    	/**
    	 * ��ΪҪ��֤�����Ѵ�Сһ�¡���>���ö�size��Ϊ[ż����ʱ�����С����]��[������ʱ�����󶥶�]����֤��������size������1��
    	 */
    	if(((sheap.size()+bheap.size())&1)==0) {//�Ѿ���ż����Ԫ�أ���������Ԫ�ز��С����
    		//������Ԫ�ؿ��ܲ����㡰�������д󶥶ѵ�Ԫ�ء�������->�Ȳ���󶥶ѣ��ٴӴ󶥶��ø����ĳ��������С����
    		bheap.offer(num);
    		sheap.offer(bheap.poll());
    	}
    	else {//�Ѿ���������Ԫ�أ��������Ĳ���󶥶�
    		//ͬ���ģ�������Ԫ�ؿ��ܲ����㡰С������С���ѵ�Ԫ�ء�->����->�Ȳ���С���ѣ��ٴ�С�����ø���С�ĳ���������󶥶�
    		sheap.offer(num);
    		bheap.offer(sheap.poll());
    	}
    }
    
    public double findMedian() {
    	//����Ԫ�ظ�����ȷ���費��Ҫ��ƽ��
    	//1.���ż����Ԫ������Ҫȡƽ��
    	//2.����returnС���ѵ�peek
    	return sheap.size()==bheap.size()?(sheap.peek()+bheap.peek())/2.0:sheap.peek();
    }
}
