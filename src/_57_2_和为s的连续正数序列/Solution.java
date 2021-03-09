package _57_2_��Ϊs��������������;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ��Ŀ��
 * ����һ�������� target ��������к�Ϊ target ���������������У����ٺ�������������
 * �����ڵ�������С�������У���ͬ���а����׸����ִ�С�������С�
 */
public class Solution {
	/**
	 * self˼·��
	 * ��˫ָ�롿��˼·ok������Ϊ����Ϥjava�Ķ�ά���飬���������List<List>д��int[][]̫ӷ�ס���>ʱ��9ms 11%..��
	 * ��ͬ��˫ָ�룬������д������Solution2��
	 * lָ��������࣬rָ�������Ҳ�
	 * 1.(l+...+r)<target: r++
	 * 2.(l+...+r)>target: l++
	 * 3.(l+...+r)==target: (1)[l,...,r]add��res(2)l++����match
	 */
	public int[][] findContinuousSequence(int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> route = new ArrayList<>();
		int l = 1;
		int r = 2;//��Ϊ�������2������
		while(l<r&&r<target) {
			if(serialSum(l,r)>target) {
				l++;
			}
			else if(serialSum(l,r)<target) {
				r++;
			}
			else {
				//1.�����������add��res
				for(int i=l;i<=r;i++) {
					route.add(i);
				}
				res.add(new ArrayList<Integer>(route));
				route.clear();
				//2.l++
				l++;
			}
		}
		/**
		 * ������Ϥjava��ά���飬����д��̫ӷ���ˣ���
		 */
		int[][] ret = new int[res.size()][];//java��ά���鶯̬��ʼ��������һ�֣�ֻ������һά��ά�����൱��ÿ��arr[k]����null�����Ե�������ĳ�ʼ����
		for(int i=0;i<res.size();i++) {
			int[] arr = new int[res.get(i).size()];
			for(int j=0;j<res.get(i).size();j++) {
				arr[j] = res.get(i).get(j);
			}
			ret[i] = arr;
		}
		return ret;
    }
	
	public int serialSum(int start,int end) {
		return ((start+end)*(end-start+1))/2;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] res = s.findContinuousSequence(15);
		for(int i=0;i<res.length;i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}
}
