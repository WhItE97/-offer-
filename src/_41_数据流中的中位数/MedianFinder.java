package _41_数据流中的中位数;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 题目：
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class MedianFinder {
	/**
	 * self思路：排序的链表-【时间O(N)6.47% 空间O(1)5.02%】
	 * 用一个ArrayList装数据流，每次addNum都需插在正确的位置
	 * [HDP.偶数个的时候，除法要注意，不是整除，所以用到BigDecimal]
	 */
	/** initialize your data structure here. */
	List<Integer> arr;
    public MedianFinder() {
    	arr = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
    	for(int i=0;i<arr.size();i++) {//寻找正确的位置插入
    		if(num<arr.get(i)) {//插在i的位置！
    			arr.add(i, num);
    			return;
    		}
    	}
    	//如果搜完了都没有比他小的，那就插在尾巴上
    	arr.add(num);
    	return;
    }
    
    public double findMedian() {
    	//base
    	if(arr.size()==0) {
    		return 0;
    	}
    	//直接get size/2
    	if((arr.size()&1)!=0) {//说明是奇数
    		return arr.get(arr.size()/2);
    	}
    	else {//偶数
    		BigDecimal num1 = new BigDecimal(arr.get(arr.size()/2));
    		BigDecimal num2 = new BigDecimal(arr.get(arr.size()/2-1));
    		BigDecimal res = num1.add(num2);
    		res = res.divide(new BigDecimal(2));
    		return res.doubleValue();
    	}
    }
}
