package _46_�����ַ�����ַ���;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ��Ŀ��
 * ����һ�����֣����ǰ������¹����������Ϊ�ַ�����0 ����� ��a�� ��1 ����� ��b����������11 ����� ��l����������25 ����� ��z����
 * һ�����ֿ����ж�����롣����ʵ��һ����������������һ�������ж����ֲ�ͬ�ķ��뷽����
 */
public class Solution {
	/**
	 * self˼·����WRONG��
	 * ����
	 * ��ͷ��ʼ��0~25 һ��ȡ��1λ or 2λ������match
	 * 
	 * dfs�����⣡
	 * dfs�Ǵ�ѡ���б�����ѡ������
	 * ������ǰ�˳��ȡ1~2λ��
	 */
	public int translateNum(int num) {
		List<Integer> nums = new ArrayList<Integer>();
		while(num!=0) {
			nums.add(num%10);
			num /= 10;
		}
		Collections.reverse(nums);
		//��arr���鿪ʼdfs
		return 1;
    }
	
	/**
	 * dfs��ܣ�
	 * def dfs(ѡ���б�·��)��
	 * 	if(�����������)��
	 * 		res.add(·��)
	 * 		return
	 * 
	 * 	for ѡ�� in ѡ���б�
	 * 		1.��ѡ�����·������ѡ���ѡ���б���ɾ��
	 * 		2.dfs
	 * 		3.����ѡ��
	 */
	List<Integer> route = new ArrayList<>();
	List<List<Integer>> res = new ArrayList<>(); 
	public void dfs(List<Integer> arr,List<Integer> route) {
		//1.if �����������
		if(arr.size()==0) {
			res.add(route);
			return;
		}
		//2.for ѡ�� in ѡ���б�//����ѡ���ʱ�����ͷ�����ɣ�
		for(int i=0;i<arr.size();i++){
			//1.��ѡ�� -> ȡ1λ����2λ��ѡ��
			
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.translateNum(123);
	}

}
