package _41_�������е���λ��;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ��Ŀ��
 * ������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 */
public class MedianFinder {
	/**
	 * self˼·�����������-��ʱ��O(N)6.47% �ռ�O(1)5.02%��
	 * ��һ��ArrayListװ��������ÿ��addNum���������ȷ��λ��
	 * [HDP.ż������ʱ�򣬳���Ҫע�⣬���������������õ�BigDecimal]
	 */
	/** initialize your data structure here. */
	List<Integer> arr;
    public MedianFinder() {
    	arr = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
    	for(int i=0;i<arr.size();i++) {//Ѱ����ȷ��λ�ò���
    		if(num<arr.get(i)) {//����i��λ�ã�
    			arr.add(i, num);
    			return;
    		}
    	}
    	//��������˶�û�б���С�ģ��ǾͲ���β����
    	arr.add(num);
    	return;
    }
    
    public double findMedian() {
    	//base
    	if(arr.size()==0) {
    		return 0;
    	}
    	//ֱ��get size/2
    	if((arr.size()&1)!=0) {//˵��������
    		return arr.get(arr.size()/2);
    	}
    	else {//ż��
    		BigDecimal num1 = new BigDecimal(arr.get(arr.size()/2));
    		BigDecimal num2 = new BigDecimal(arr.get(arr.size()/2-1));
    		BigDecimal res = num1.add(num2);
    		res = res.divide(new BigDecimal(2));
    		return res.doubleValue();
    	}
    }
}
