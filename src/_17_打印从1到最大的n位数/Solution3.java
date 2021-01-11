package _17_��ӡ��1������nλ��;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution3().printNumbers(5)));
	}
/**
 * self˼·�ܽ᣺
 * ���������Ե�ʱ������Ҫ����nΪ�����ģ�int/long��װ���µ����֣�
 * ���Բ���ֱ�ӱ�������leetcode������int[]�ķ���ֵ�����Կ���ֱ�ӱ���..��
 * KP1.ʹ�ò���λ����String��װ���ִ�
 * KP2.��1->nλ��������� ˳���ӡ�����Կ����Ƕ�ÿһλ�Ĵ�0->1��dfs��
 * ATT.Ҫע�⵽���������ͷ����λ��Ϊ0����������Ҫȥ��0�ģ�
 * ��WRONG POINT���Լ���һ��д��ʱ��ֱ��dfsȫд��res List�ˣ��ٱ���[ÿ��]�ַ�����[ÿ��]�ַ���ȥ0...
 * ��ʱ�临�Ӷ�������..�кܶ����ù���->so obviously��ʱ�ˣ�
 * ���Ľ�˼·�����ڲ���res List֮ǰ�Ͱ��ж����ã���
 * ������������
 * 	1.�������nλ������ֳ�n��dfs���ֱ��1λ->nλ ����dfs
 * 	2.��kλ����dfs��ʱ���䷶Χ����100...~999...��kλ��
 * 	3.����ÿ��dfs��ʱ���ж�һ���ǵ�һλ�Ļ����ʹ�1~9��ѡ�񣻷ǵ�һλ�Ļ��ʹ�0~9��ѡ��
 * 
 * for(int i=1;i<n;i++){
 * 	dfs(i,..)
 * }
 * 
 * def dfs(i,...){
 * 	start=0;
 * 	if�ǵ�һλ:
 * 		start=1;	
 * 	for(int i=start;i<choices.length;i++){
 * 		��ѡ��;
 * 		dfs();
 * 		����ѡ��;
 * 	}
 * }
 */
	public int[] printNumbers(int n) {
		char[] choices = new char[] {'0','1','2','3','4','5','6','7','8','9'};
		for(int i=1;i<=n;i++) {
			dfs(i,sb,choices);
		}
		int[] ret = toInt(res);
		return ret;
	}
	
	List<String> res = new ArrayList<String>();
	StringBuilder sb = new StringBuilder();
	//ֻ�ݹ�����kλ���ģ�Ȼ���kһ��for����1~n����>k=1:1~9;k=2:10~99;k=3:100~999(��һ��ѡ���1~9ѡ���Ժ󶼴�0~9ѡ)
	public void dfs(int k,StringBuilder sb,char[] choices) {
		//�˳�����
		if(sb.length()==k) {
			res.add(new String(sb.toString()));
			return ;
		}
		int start = 0;//����ѡ���0~9
		//�ж��ǲ��ǵ�һ��ѡ���ǵĻ���ֻ��ѡ1~9
		if(sb.length()==0) {
			start=1;
		}
		//for ѡ�� in ѡ���б�
		for(int i=start;i<choices.length;i++) {
			//��ѡ��
			sb.append(choices[i]);
			//dfs
			dfs(k,sb,choices);
			//����ѡ��
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	public int[] toInt(List<String> res) {
		int arr[] = new int[res.size()];
		for(int i=0;i<res.size();i++) {
			arr[i] = Integer.parseInt(res.get(i));
		}
		return arr;
	}
}
